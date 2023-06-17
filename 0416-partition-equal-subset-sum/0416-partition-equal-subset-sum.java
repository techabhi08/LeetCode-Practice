class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        if(sum % 2 != 0){
            return false;
        }
        int[][] dp = new int[n][sum + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return findSum(n - 1, nums, sum / 2, dp);
    }
    
    public boolean findSum(int index, int[] nums, int target, int[][] dp){
        if(target == 0){
            return true;
        }
        if(index == 0){
            return nums[0] == target;
        }
        
        if(dp[index][target] != -1){
            return dp[index][target] == 1 ? true : false;
        }
        
        boolean notTake = findSum(index - 1, nums, target, dp);
        boolean take = false;
        if(nums[index] <= target){
            take = findSum(index - 1, nums, target - nums[index], dp);
        }
        
        dp[index][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }
}