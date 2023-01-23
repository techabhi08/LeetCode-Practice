class Solution {
    public int maxProfit(int j, int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][j + 1];
        int[][] curr = new int[2][j + 1];
        
        for(int index = n - 1; index >= 0; index--){
            for(int buy = 0; buy <= 1; buy++){
                for(int k = 1; k <= j; k++){
                    if(buy == 1){
                        curr[buy][k] = Math.max(-prices[index] + ahead[0][k], ahead[1][k]);
                    }else{
                        curr[buy][k] = Math.max(prices[index] + ahead[1][k - 1],ahead[0][k]);
                    }
                }
            }
            ahead = (int[][])curr.clone();
        }
        return ahead[1][j];
    }
    
}
