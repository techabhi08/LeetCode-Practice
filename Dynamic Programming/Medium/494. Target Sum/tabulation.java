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
        if(nums[0] == 0){
            dp[0][0] = 2;
        }else{
            dp[0][0] = 1;
        }
        if(nums[0] != 0 && nums[0] <= s2){
            dp[0][nums[0]] = 1;
        }
        
        for(int index = 1; index < n; index++){
            for(int tar = 0; tar <= s2; tar++){
                int take = 0;
                if(nums[index] <= tar){
                    take = dp[index - 1][tar - nums[index]];
                }
                int notTake = dp[index - 1][tar];

                dp[index][tar] = take + notTake;
            }
        }
        
        return dp[n - 1][s2];
    }
    
}
