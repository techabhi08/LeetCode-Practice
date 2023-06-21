class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findMax(0, 1, prices, dp);
    }
    
    public int findMax(int index, int canBuy, int[] price, int[][] dp){
        if(index >= price.length){
            return 0;
        }
        
        if(dp[index][canBuy] != -1){
            return dp[index][canBuy];
        }
        
        if(canBuy == 1){
            return dp[index][canBuy] = Math.max(-price[index] + findMax(index + 1, 0, price, dp), findMax(index + 1, 1, price, dp));
        }
        return dp[index][canBuy] = Math.max(price[index] + findMax(index + 1, 1, price, dp), findMax(index + 1, 0, price, dp));
    }
}