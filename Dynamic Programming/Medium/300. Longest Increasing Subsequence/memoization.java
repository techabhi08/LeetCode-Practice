class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findLIS(0, -1, nums, dp);
    }
    
    public int findLIS(int index, int prev, int[] nums, int[][] dp){
        if(index == nums.length){
            return 0;
        }
        
        if(dp[index][prev + 1] != -1){
            return dp[index][prev + 1];
        }
        int take = 0;
        if(prev == -1 || nums[prev] < nums[index]){
            take = 1 + findLIS(index + 1, index, nums, dp);
        }
        int notTake = findLIS(index + 1, prev, nums, dp);
        
        return dp[index][prev + 1] = Math.max(take, notTake);
    }
}
