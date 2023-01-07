class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int i = 0; i <= amount; i++){
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }
        
        for(int index = 1; index < n; index++){
            for(int tar = 0; tar <= amount; tar++){
                int take = 0;
                if(coins[index] <= tar){
                    take = dp[index][tar - coins[index]];
                }
                int notTake = dp[index - 1][tar];
                dp[index][tar] = take + notTake;
            }
        }
        return dp[n - 1][amount];
    }
}
