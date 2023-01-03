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
        // int target = sum / 2;
        boolean[][] dp = new boolean[n][sum / 2 + 1];
        if(nums[0] <= sum / 2) dp[0][nums[0]] = true;
        
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        
        for(int index = 1; index < n; index++){
            for(int target = 1; target <= sum / 2; target++){
                boolean take = false;
                if(target >= nums[index]){
                    take = dp[index - 1][target - nums[index]];
                }
                boolean notTake = dp[index - 1][target];
                dp[index][target] = take || notTake;
            }
        }
        
        return dp[nums.length - 1][sum / 2];
    }
}
