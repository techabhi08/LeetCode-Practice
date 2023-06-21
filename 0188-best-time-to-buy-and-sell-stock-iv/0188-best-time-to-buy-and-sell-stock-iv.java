class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];
        
        for(int index = n - 1; index >= 0; index--){
            for(int canBuy = 0; canBuy <= 1; canBuy++){
                for(int j = 1; j <= k; j++){
                    if(canBuy == 1){
                        dp[index][canBuy][j] = Math.max(-prices[index] + dp[index + 1][0][j],
                                       dp[index + 1][1][j]);
                    }else{
                        dp[index][canBuy][j] = Math.max(prices[index] + dp[index+1][1][j - 1], 
                                    dp[index + 1][0][j]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}