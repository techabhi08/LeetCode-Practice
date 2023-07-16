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
        int[][] dp = new int[n][sum / 2 + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return findSum(n - 1, nums, sum / 2, dp);
    }
    
    public boolean findSum(int index, int[] nums, int sum, int[][] dp){
        if(sum == 0){
            return true;
        }
        if(index == 0){
            return nums[0] == sum;
        }
        
        if(dp[index][sum] != -1){
            return dp[index][sum] == 1 ? true : false;
        }
        
        boolean notTake = findSum(index - 1, nums, sum, dp);
        boolean take = false;
        if(nums[index] <= sum){
            take = findSum(index - 1, nums, sum - nums[index], dp);
        }
        
        dp[index][sum] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }
}