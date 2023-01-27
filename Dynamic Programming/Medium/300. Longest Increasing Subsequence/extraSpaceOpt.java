class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = dp[0];
        
        for(int index = 0; index < n; index++){
            for(int prev = 0; prev <= index - 1; prev++){
                if(nums[prev] < nums[index]){
                    dp[index] = Math.max(1 + dp[prev], dp[index]);
                    max = Math.max(max, dp[index]);
                }
            }
        }
        return max;
    }
}
