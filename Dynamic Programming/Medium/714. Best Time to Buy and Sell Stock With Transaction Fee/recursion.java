class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        
        return findProfit(0, 1, prices, fee);
    }
    
    public int findProfit(int index, int buy, int[] prices, int fee){
        if(index == prices.length){
            return 0;
        }
        
        if(buy == 1){
            return Math.max(-prices[index] + findProfit(index + 1, 0, prices, fee), 
                           findProfit(index + 1, 1, prices, fee));
        }else{
            return Math.max(prices[index] - fee + findProfit(index + 1, 1, prices, fee),
                           findProfit(index + 1, 0, prices, fee));
        }
    }
}
