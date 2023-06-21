class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][3];
        int[][] curr = new int[2][3];
        
        for(int index = n - 1; index >= 0; index--){
            for(int count = 2; count > 0; count--){
                curr[1][count] = Math.max(-prices[index] + ahead[0][count], ahead[1][count]);
                curr[0][count] = Math.max(prices[index] + ahead[1][count - 1], ahead[0][count]);
            }
            ahead = (int[][])curr.clone();
        }
        return ahead[1][2];
    }
}