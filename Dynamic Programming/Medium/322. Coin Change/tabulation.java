class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int ans = 0;
        int[][] dp = new int[n][amount + 1];
        
        for(int t = 0; t <= amount; t++){
            dp[0][t] = t % coins[0] == 0 ? t / coins[0] : (int)1e8;
        }
        
        for(int index = 1; index < n; index++){
            for(int a = 0; a <= amount; a++){
                int notTake = dp[index - 1][a];
                int take = (int)1e8;
                if(coins[index] <= a){
                    take = 1 + dp[index][a - coins[index]];
                }
                dp[index][a] = Math.min(take, notTake);
            }
        }
        
        ans = dp[n - 1][amount];
        return ans == 1e8 ? -1 : ans;
    }
}
