class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = findMax(0, target, nums, dp);
        return ans < 0 ? - 1 : ans;
    }
    
    public int findMax(int index, int target, int[] nums, int[] dp){
        if(index == nums.length - 1){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int res = Integer.MIN_VALUE;
        for(int i = index + 1; i < nums.length; i++){
            if(nums[i] - nums[index] <= target && nums[i] - nums[index] >= -target){
                res = Math.max(res, 1 + findMax(i, target, nums, dp));
            }
        }
        return dp[index] = res;
    }
}