class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        int s2 = (sum - target) / 2;
        
        if(sum - target < 0 || (sum - target) % 2 != 0){
            return 0;
        }
        int[][] dp = new int[n][s2 + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findWays(n - 1, nums, s2, dp);
    }
    
    public int findWays(int index, int[] nums, int target, int[][] dp){
        if(index == 0){
            if(target == 0 && nums[index] == 0){
                return 2;
            }
            if(target == 0 || nums[index] == target)
                return 1;
            return 0;
        }
        
        if(dp[index][target] != -1){
            return dp[index][target];
        }
        
        int take = 0;
        if(nums[index] <= target){
            take = findWays(index - 1, nums, target - nums[index], dp);
        }
        int notTake = findWays(index - 1, nums, target, dp);
        
        return dp[index][target] = take + notTake;
    }
}
