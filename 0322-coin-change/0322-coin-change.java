class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans = findMin(n - 1, amount, coins, dp);
        return ans == (int)1e8 ? -1 : ans;
    }
    
    public int findMin(int index, int target, int[] coins, int[][] dp){
        if(index == 0){
            return target % coins[index] == 0 ? target / coins[0] : (int)1e8;
        }
        
        if(dp[index][target] != -1){
            return dp[index][target];
        }
        
        int notTake = findMin(index - 1, target, coins, dp);
        int take = (int)1e8;
        if(coins[index] <= target){
            take = 1 + findMin(index, target - coins[index], coins, dp);
        }
        
        return dp[index][target] = Math.min(take, notTake);
    }
}