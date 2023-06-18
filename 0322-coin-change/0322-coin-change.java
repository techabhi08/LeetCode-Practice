class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        int ans = findMin(n - 1, amount, coins, dp);
        return ans == (int)1e8 ? -1 : ans;
    }
    
    public int findMin(int index, int amount, int[] coins, int[][] dp){
        if(index == 0){
            if(amount % coins[0] == 0){
                return amount / coins[0];
            }
            return (int)1e8;
        }
        
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        
        int notTake = findMin(index - 1, amount, coins, dp);
        int take = (int)1e8;
        if(coins[index] <= amount){
            take = 1 + findMin(index, amount - coins[index], coins, dp);
        }
        
        return dp[index][amount] = Math.min(take, notTake);
    }
}