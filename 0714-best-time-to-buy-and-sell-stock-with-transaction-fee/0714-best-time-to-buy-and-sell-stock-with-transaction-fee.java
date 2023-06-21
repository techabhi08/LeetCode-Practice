class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        
        int[] ahead = new int[2];
        int[] curr = new int[2];
        
        for(int index = n - 1; index >= 0; index--){
            for(int canBuy = 0; canBuy <= 1; canBuy++){
                if(canBuy == 1){
                    curr[canBuy] = Math.max(-prices[index] + ahead[0], ahead[1]);
                }else{
                    curr[canBuy] = Math.max(prices[index] - fee + ahead[1], ahead[0]);
                }
            }
            ahead = (int[])curr.clone();
        }
        return ahead[1];
    }
}