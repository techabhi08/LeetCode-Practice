class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findChange(n - 1, amount, coins, dp);
    }
    
    public int findChange(int index, int amount, int[] coins, int[][] dp){
        if(index == 0){
            return amount % coins[0] == 0 ? 1 : 0;
        }
        
        if(amount == 0){
            return 1;
        }
        
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        
        int take = 0;
        if(coins[index] <= amount){
            take = findChange(index, amount - coins[index], coins, dp);
        }
        int notTake = findChange(index - 1, amount, coins, dp);
        return dp[index][amount] = take + notTake;
    }
}
