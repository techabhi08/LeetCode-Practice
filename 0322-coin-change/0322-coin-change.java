class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int i = 1; i <= amount; i++){
            dp[0][i] = i % coins[0] == 0 ? i / coins[0] : (int)1e8;
        }
        
        for(int index = 1; index < n; index++){
            for(int target = 1; target <= amount; target++){
                int notTake = dp[index - 1][target];
                int take = (int)1e8;
                if(coins[index] <= target){
                    take = 1 + dp[index][target - coins[index]];
                }

                dp[index][target] = Math.min(take, notTake);
            }
        }
        int ans = dp[n - 1][amount];
        return ans == (int)1e8 ? -1 : ans;
    }
}