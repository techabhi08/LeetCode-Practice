class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        
        for(int index = n - 1; index >= 0; index--){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 1){
                    dp[index][buy] = Math.max(-prices[index]+dp[index+1][0],dp[index+1][1]);
                }else{
                    dp[index][buy] = Math.max(prices[index]-fee+dp[index+1][1],dp[index+1][0]);
                }
            }
        }
        return dp[0][1];
    }
}
