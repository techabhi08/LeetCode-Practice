class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findMax(0, 1, prices, dp);
    }
    
    public int findMax(int index, int canBuy, int[] prices, int[][] dp){
        if(index >= prices.length){
            return 0;
        }
        
        if(dp[index][canBuy] != -1){
            return dp[index][canBuy];
        }
        
        if(canBuy == 1){
            return dp[index][canBuy] = Math.max(-prices[index] + findMax(index + 1, 0, prices, dp), 
                           findMax(index + 1, 1, prices, dp));
        }
        return dp[index][canBuy] = Math.max(prices[index] + findMax(index + 2, 1, prices, dp), 
                       findMax(index + 1, 0, prices, dp));
    }
}