class Solution {
    public int coinChange(int[] coins, int amt) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n][amt + 1];
        for(int i = 0; i <= amt; i++){
            dp[0][i] = i % coins[0] == 0 ? i / coins[0] : (int)1e8;
        }
        
        for(int index = 1; index < n; index++){
            for(int amount = 0; amount <= amt; amount++){
                int notTake = dp[index - 1][amount];
                int take = (int)1e8;
                if(coins[index] <= amount){
                    take = 1 + dp[index][amount - coins[index]];
                }

                dp[index][amount] = Math.min(take, notTake);
            }
        }
        
        int ans = dp[n - 1][amt];
        return ans == (int)1e8 ? -1 : ans;
    }
    
}