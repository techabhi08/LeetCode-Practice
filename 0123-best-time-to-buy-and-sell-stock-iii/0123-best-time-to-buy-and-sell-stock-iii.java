class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] rows : dp){
            for(int[] row : rows){
                Arrays.fill(row, -1);
            }
        }
        return findMax(0, 1, 2, prices, dp);
    }
    
    public int findMax(int index, int canBuy, int count, int[] prices, int[][][] dp){
        if(count == 0 || index == prices.length){
            return 0;
        }
        
        if(dp[index][canBuy][count] != -1){
            return dp[index][canBuy][count];
        }
        
        if(canBuy == 1){
            return dp[index][canBuy][count] = Math.max(-prices[index] + findMax(index + 1, 0, count, prices, dp), findMax(index + 1, 1, count, prices, dp));
        }
        return dp[index][canBuy][count] = Math.max(prices[index] + findMax(index + 1, 1, count - 1, prices, dp), findMax(index + 1, 0, count, prices, dp));
    }
}