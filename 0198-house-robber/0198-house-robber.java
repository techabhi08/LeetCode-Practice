class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return findMax(0, nums, dp);
    }
    
    public int findMax(int index, int[] nums, int[] dp){
        if(index >= nums.length){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int take = nums[index] + findMax(index + 2, nums, dp);
        int notTake = findMax(index + 1, nums, dp);
        return dp[index] = Math.max(take, notTake);
    }
}