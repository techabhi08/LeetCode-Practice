class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length; 
        int[][] dp = new int[n][amount + 1];
        for(int i = 0; i <= amount; i++){
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        
        for(int index = 1; index < n; index++){
            for(int amt = 1; amt <= amount; amt++){
                int notTake = dp[index - 1][amt];
                int take = 0;
                if(coins[index] <= amt){
                    take = dp[index][amt - coins[index]];
                }

                dp[index][amt] = take + notTake;
            }
        }
        return dp[n - 1][amount];
    }
}