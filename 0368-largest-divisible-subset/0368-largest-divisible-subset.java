class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int[] hash = new int[n];
        
        int lastIndex = 0;
        int max = 1;
        
        for(int i = 1; i < nums.length; i++){
            hash[i] = i;
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j]== 0 && dp[j] + 1  > dp[i]){
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                lastIndex = i;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            ans.add(0, nums[lastIndex]);
        }
        return ans;
    }
}