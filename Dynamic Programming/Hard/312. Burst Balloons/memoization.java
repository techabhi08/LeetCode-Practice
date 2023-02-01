class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        int index = 1;
        for(int num : nums){
            arr[index++] = num;
        }
        
        int[][] dp = new int[n + 1][n + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findCoins(1, n, arr, dp);
    }
    
    public int findCoins(int i, int j, int[] nums, int[][] dp){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++){
            int coins = nums[i - 1] * nums[j + 1] * nums[k] + findCoins(i, k - 1, nums, dp) + findCoins(k + 1, j, nums, dp);
            max = Math.max(max, coins);
        }
        return dp[i][j] = max;
    }
}
