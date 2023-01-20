class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] rows : dp){
            for(int[] row : rows){
                Arrays.fill(row, -1);
            }
        }
        return findProfit(0, 1, prices, 2, dp);
    }
    
    public int findProfit(int index, int canBuy, int[] prices, int count, int[][][] dp){
        if(count == 0 || index == prices.length){
            return 0;
        }
        
        if(dp[index][canBuy][count] != -1){
            return dp[index][canBuy][count];
        }
        
        if(canBuy == 1){
            return dp[index][canBuy][count] = Math.max(-prices[index] + 
                        findProfit(index + 1, 0, prices, count, dp), 
                        findProfit(index + 1, 1, prices, count, dp));
        }
        return dp[index][canBuy][count] = Math.max(prices[index] + 
                        findProfit(index + 1, 1, prices, count - 1, dp), 
                       findProfit(index + 1, 0, prices, count, dp));
    }
}
