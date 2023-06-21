class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][3];
        int[][] curr = new int[2][3];
        
        for(int index = n - 1; index >= 0; index--){
            for(int canBuy = 0; canBuy <= 1; canBuy++){
                for(int count = 2; count > 0; count--){
                    if(canBuy == 1){
                        curr[canBuy][count] = Math.max(-prices[index] + 
                                        ahead[0][count], ahead[1][count]);
                    }else{
                        curr[canBuy][count] = Math.max(prices[index] + 
                                        ahead[1][count - 1], ahead[0][count]);
                    }
                }
            }
            ahead = (int[][])curr.clone();
        }
        return ahead[1][2];
    }
}