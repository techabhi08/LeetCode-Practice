class Solution {
    public int maxProfit(int j, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][j + 1];
        
        for(int index = n - 1; index >= 0; index--){
            for(int buy = 0; buy <= 1; buy++){
                for(int k = 1; k <= j; k++){
                    if(buy == 1){
                        dp[index][buy][k] = Math.max(-prices[index] + dp[index + 1][0][k],
                                                     dp[index + 1][1][k]);
                    }else{
                        dp[index][buy][k] = Math.max(prices[index] + dp[index + 1][1][k - 1],
                                                     dp[index + 1][0][k]);
                    }
                }
            }
        }
        return dp[0][1][j];
    }
    
}
