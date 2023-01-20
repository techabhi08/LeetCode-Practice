class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return findProfit(0, 1, prices, 2);
    }
    
    public int findProfit(int index, int canBuy, int[] prices, int count){
        if(count == 0 || index == prices.length){
            return 0;
        }
        
        if(canBuy == 1){
            return Math.max(-prices[index] + findProfit(index + 1, 0, prices, count), 
                           findProfit(index + 1, 1, prices, count));
        }
        return Math.max(prices[index] + findProfit(index + 1, 1, prices, count - 1), 
                       findProfit(index + 1, 0, prices, count));
    }
}
