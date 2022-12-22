class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = -1;
        }
        return findProfit(n - 1, nums, dp);
    }
    
    public int findProfit(int index, int[] nums, int[] dp){
        if(index == 0){
            return nums[index];
        }
        
        if(index < 0){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int notPick = 0 + findProfit(index - 1, nums, dp);
        int pick = nums[index] + findProfit(index - 2, nums, dp);
        
        return dp[index] =  Math.max(notPick, pick);
    }
}
