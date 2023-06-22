class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] hash = new int[nums.length];
        
        int lastIndex = 0;
        int max = 1;
        
        for(int i = 1; i < nums.length; i++){
            hash[i] = i;
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                lastIndex = i;
            }
        }
        
        ans.add(nums[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            ans.add(0, nums[lastIndex]);
        }
        return ans;
    }
}