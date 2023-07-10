class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        
        for(int index = n - 1; index >= 0; index--){
            for(int prev = index - 1; prev >= -1; prev--){
                int take = 0;
                if(prev == -1 || nums[prev] < nums[index]){
                    take = 1 + dp[index + 1][index + 1];
                }
                int notTake = dp[index + 1][prev + 1];

                dp[index][prev + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }
}