class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return findChange(coins.length - 1, coins, amount, dp);
    }
    
    public int findChange(int index, int[] coins, int amount, int[][] dp){
        if(index == 0){
            return amount % coins[0] == 0 ? 1 : 0;
        }
        
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        
        int take = 0;
        if(coins[index] <= amount){
            take = findChange(index, coins, amount - coins[index], dp);
        }
        int notTake = findChange(index - 1, coins, amount, dp);
        
        return dp[index][amount] = take + notTake;
    }
}