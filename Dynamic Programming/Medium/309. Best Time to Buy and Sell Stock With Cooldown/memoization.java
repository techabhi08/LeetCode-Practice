class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findProfit(0, 1, prices, dp);
    }
    
    public int findProfit(int index, int buy, int[] prices, int[][] dp){
        if(index >= prices.length){
            return 0;
        }
        
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        
        if(buy == 1){
            return dp[index][buy] = Math.max(-prices[index] + findProfit(index + 1, 0, prices, dp), findProfit(index + 1, 1, prices, dp));
        }else{
            return dp[index][buy] = Math.max(prices[index] + findProfit(index + 2, 1, prices, dp), findProfit(index + 1, 0, prices, dp));
        }
    }
}
