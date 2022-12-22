class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        
        dp[0] = nums[0];
        
        for(int index = 1; index < n; index++){
            int notPick = 0 + dp[index - 1];
            int pick = nums[index];
            if(index > 1) pick += dp[index - 2];
            dp[index] =  Math.max(notPick, pick);
        }
        return dp[n - 1];
    }
}
