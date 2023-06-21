class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        
        int[][] dp = new int[n + 1][2];
        
        for(int index = n - 1; index >= 0; index--){
            for(int canBuy = 0; canBuy <= 1; canBuy++){
                if(canBuy == 1){
                    dp[index][canBuy] = Math.max(-prices[index] + dp[index + 1][0], 
                                                 dp[index + 1][1]);
                }else{
                    dp[index][canBuy] = Math.max(prices[index] - fee + dp[index + 1][1], dp[index + 1][0]);
                }
            }
        }
        return dp[0][1];
    }
}