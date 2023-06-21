class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][k + 1];
        int[][] curr = new int[2][k + 1];
        
        for(int index = n - 1; index >= 0; index--){
            for(int canBuy = 0; canBuy <= 1; canBuy++){
                for(int j = 1; j <= k; j++){
                    if(canBuy == 1){
                        curr[canBuy][j] = Math.max(-prices[index] + ahead[0][j], ahead[1][j]);
                    }else{
                        curr[canBuy][j] = Math.max(prices[index] + ahead[1][j - 1], 
                                                   ahead[0][j]);
                    }
                }
            }
            ahead = (int[][])curr.clone();
        }
        return ahead[1][k];
    }
}