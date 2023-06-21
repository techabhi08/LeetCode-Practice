class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        
        int[][] dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findMax(0, 1, fee, prices, dp);
    }
    
    public int findMax(int index, int canBuy, int fee, int[] prices, int[][] dp){
        if(index == prices.length){
            return 0;
        }
        
        if(dp[index][canBuy] != -1){
            return dp[index][canBuy];
        }
        
        if(canBuy == 1){
            return dp[index][canBuy] = Math.max(-prices[index] + findMax(index + 1, 0, fee, prices, dp),
                            findMax(index + 1, 1, fee, prices, dp));
        }
        return dp[index][canBuy] = Math.max(prices[index] - fee + findMax(index + 1, 1, fee, prices, dp),
                       findMax(index + 1, 0, fee, prices, dp));
    }
}