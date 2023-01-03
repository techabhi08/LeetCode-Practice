class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        int n = nums.length;
        int[][] dp = new int[200][sum / 2 + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findSum(nums.length - 1, sum / 2, nums, dp);
    }
    
    public boolean findSum(int index, int target, int[] nums, int[][] dp){
        if(index == 0){
            return nums[index] == target;
        }
        
        if(target == 0){
            return true;
        }
        
        if(dp[index][target] != -1){
            return dp[index][target] == 1 ? true : false;
        }
        
        boolean take = false;
        if(target >= nums[index]){
            take = findSum(index - 1, target - nums[index], nums, dp);
        }
        boolean notTake = findSum(index - 1, target, nums, dp);
        
        
        dp[index][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }
}
