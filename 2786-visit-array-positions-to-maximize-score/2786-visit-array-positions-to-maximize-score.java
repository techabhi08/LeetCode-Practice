class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        for(long[] row : dp){
            Arrays.fill(row, -1);
        }
        return nums[0] + findAns(1, isOdd(nums[0]), nums, x, dp);
    }
    
    public long findAns(int index, boolean prevParity, int[] nums, int x, long[][] dp){
        if(index == nums.length){
            return 0;
        }
        
        if(dp[index][prevParity ? 1 : 0] != -1){
            return dp[index][prevParity ? 1 : 0];
        }
        
        long notTake = findAns(index + 1, prevParity, nums, x, dp);
        boolean currParity = isOdd(nums[index]);
        long take = nums[index] + findAns(index + 1, currParity, nums, x, dp) - (prevParity == currParity ? 0 : x);
        
        return dp[index][prevParity ? 1 : 0] = Math.max(take, notTake);
    }
    
    public boolean isOdd(int n){
        return (n & 1) == 1;
    }
}