class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int ans = 0;
        int[][] dp = new int[n][amount + 1];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        ans = findChange(n - 1, coins, amount, dp);
        return ans == 1e8 ? -1 : ans;
    }
    
    public int findChange(int index, int[] coins, int amount, int[][] dp){
        if(index == 0){
            if(amount % coins[index] == 0){
                return amount / coins[index];
            }else{
                return (int)1e8;
            }
        }
        
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        
        int notTake = findChange(index - 1, coins, amount, dp);
        int take = (int)1e8;
        if(coins[index] <= amount){
            take = 1 + findChange(index, coins, amount - coins[index], dp);
        }
        
        return dp[index][amount] = Math.min(take, notTake);
    }
}
