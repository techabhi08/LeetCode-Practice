class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        return findProfit(0, 1, prices);
    }
    
    public int findProfit(int index, int canBuy, int[] prices){
        if(index == prices.length){
            return 0;
        }
        
        if(canBuy == 1){
            return Math.max(-prices[index] + findProfit(index + 1, 0, prices), findProfit(index + 1, 1, prices));
        }
        return Math.max(prices[index] + findProfit(index + 1, 1, prices), findProfit(index + 1, 0, prices));
    }
}
