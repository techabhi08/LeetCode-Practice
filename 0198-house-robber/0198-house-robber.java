class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        
        for(int index = 1; index < n; index++){
            int take = nums[index];
            if(index - 2 >= 0) take += dp[index - 2];
            int notTake = dp[index - 1];
            
            dp[index] = Math.max(take, notTake);
        }
        
        return dp[n - 1];
    }
}