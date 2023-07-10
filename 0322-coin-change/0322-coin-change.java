class Solution {
    public int coinChange(int[] coins, int target) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n][target + 1];
        for(int i = 1; i <= target; i++){
            if(i % coins[0] == 0){
                dp[0][i] = i / coins[0];
            }else{
                dp[0][i] = (int)1e8;
            }
        }
        
        for(int index = 1; index < n; index++){
            for(int amount = 1; amount <= target; amount++){
                int notTake = dp[index - 1][amount];
                int take = (int)1e8;
                if(coins[index] <= amount){
                    take = 1 + dp[index][amount - coins[index]];
                }
                dp[index][amount] = Math.min(take, notTake);
            }
        }
        
        return dp[n - 1][target] == (int)1e8 ? -1 : dp[n - 1][target];
    }
}