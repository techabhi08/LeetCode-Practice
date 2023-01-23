class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];
        for(int[][] rows : dp){
            for(int[] row : rows){
                Arrays.fill(row, -1);
            }
        }
        return findProfit(0, 1, k, prices, dp);
    }
    
    public int findProfit(int index, int buy, int k, int[] prices, int[][][] dp){
        if(index == prices.length || k == 0){
            return 0;
        }
        
        if(dp[index][buy][k] != -1){
            return dp[index][buy][k];
        }
        
        if(buy == 1){
            return dp[index][buy][k] = Math.max(-prices[index] + 
                        findProfit(index + 1, 0, k, prices, dp),
                        findProfit(index + 1, 1, k, prices, dp));
        }
        return dp[index][buy][k] = Math.max(prices[index] + findProfit(index + 1, 1, k - 1, prices ,dp), findProfit(index + 1, 0, k, prices, dp));
    }
}
