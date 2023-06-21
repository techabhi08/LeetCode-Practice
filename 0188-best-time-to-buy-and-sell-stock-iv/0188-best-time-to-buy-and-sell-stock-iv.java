class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];
        for(int[][] rows : dp){
            for(int[] row : rows){
                Arrays.fill(row, -1);
            }
        }
        return findMax(0, 1, k, prices, dp);
    }
    
    public int findMax(int index, int canBuy, int k, int[] prices, int[][][] dp){
        if(index == prices.length || k == 0){
            return 0;
        }
        
        if(dp[index][canBuy][k] != -1){
            return dp[index][canBuy][k];
        }
        
        if(canBuy == 1){
            return dp[index][canBuy][k] = Math.max(-prices[index] + findMax(index + 1, 0, k, prices, dp),
                           findMax(index + 1, 1, k, prices, dp));
        }
        return dp[index][canBuy][k] = Math.max(prices[index] + findMax(index + 1, 1, k - 1, prices, dp),
                       findMax(index + 1, 0, k, prices, dp));
    }
}