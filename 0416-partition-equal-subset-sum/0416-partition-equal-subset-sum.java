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
        boolean[][] dp = new boolean[n][sum / 2 + 1];
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        
        if(nums[0] <= sum / 2) dp[0][nums[0]] = true;
        
        for(int index = 1; index < n; index++){
            for(int target = 1; target <= sum / 2; target++){
                boolean notTake = dp[index - 1][target];
                boolean take = false;
                if(nums[index] <= target){
                    take = dp[index - 1][target - nums[index]];
                }

                dp[index][target] = (take || notTake);
            }
        }
        
        return dp[n - 1][sum / 2];
    }
}