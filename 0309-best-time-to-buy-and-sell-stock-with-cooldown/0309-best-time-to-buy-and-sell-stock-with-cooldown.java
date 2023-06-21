class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        
        for(int index = n - 1; index >= 0; index--){
            dp[index][1] = Math.max(-prices[index] + dp[index + 1][0], dp[index + 1][1]);
            dp[index][0] = Math.max(prices[index] + (index + 2 <= n ? dp[index + 2][1] : 0), dp[index + 1][0]);
        }
        return dp[0][1];
    }
}