class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][k + 1];
        int[][] curr = new int[2][k + 1];
        
        for(int index = n - 1; index >= 0; index--){
            for(int j = 1; j <= k; j++){
                curr[1][j] = Math.max(-prices[index] + ahead[0][j], ahead[1][j]);
                curr[0][j] = Math.max(prices[index] + ahead[1][j - 1], ahead[0][j]);
            }
            ahead = (int[][])curr.clone();
        }
        return ahead[1][k];
    }
}