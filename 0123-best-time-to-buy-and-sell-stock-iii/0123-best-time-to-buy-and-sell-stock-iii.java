class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        
        for(int index = n - 1; index >= 0; index--){
            for(int canBuy = 0; canBuy <= 1; canBuy++){
                for(int count = 2; count > 0; count--){
                    if(canBuy == 1){
                        dp[index][canBuy][count] = Math.max(-prices[index] + 
                                        dp[index + 1][0][count], dp[index + 1][1][count]);
                    }else{
                        dp[index][canBuy][count] = Math.max(prices[index] + 
                                        dp[index + 1][1][count - 1], dp[index + 1][0][count]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}