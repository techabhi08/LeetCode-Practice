class Solution {
    public int change(int amt, int[] coins) {
        int n = coins.length;
        
        int[][] dp = new int[n][amt + 1];
        for(int i = 0; i <= amt; i++){
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }
        
        for(int index = 1; index < n; index++){
            for(int amount = 0; amount <= amt; amount++){
                int notTake = dp[index - 1][amount];
                int take = 0;
                if(coins[index] <= amount){
                    take = dp[index][amount - coins[index]];
                }

                dp[index][amount] = take + notTake;
            }
        }
        return dp[n - 1][amt];
    }
}