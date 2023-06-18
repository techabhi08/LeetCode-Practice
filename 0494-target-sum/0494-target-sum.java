class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total += num;
        }
        
        int s2 = (total - target) / 2;
        if(total - target < 0 || (total - target) % 2 != 0){
            return 0;
        }
        
        int[][] dp = new int[n][s2 + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findTarget(n - 1, nums, s2, dp);
    }
    
    public int findTarget(int index, int[] nums, int sum, int[][] dp){
        if(index == 0){
            if(sum == 0 && nums[0] == 0) return 2;
            if(sum == 0 || nums[index] == sum) return 1;
            return 0;
        }
        
        if(dp[index][sum] != -1){
            return dp[index][sum];
        }
        
        int notTake = findTarget(index - 1, nums, sum, dp);
        int take = 0;
        if(nums[index] <= sum){
            take = findTarget(index - 1, nums, sum - nums[index], dp);
        }
        
        return dp[index][sum] = take + notTake;
    }
}