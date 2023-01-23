class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        return findProfit(0, 1, k, prices);
    }
    
    public int findProfit(int index, int buy, int k, int[] prices){
        if(index == prices.length || k == 0){
            return 0;
        }
        
        if(buy == 1){
            return Math.max(-prices[index] + findProfit(index + 1, 0, k, prices),
                           findProfit(index + 1, 1, k, prices));
        }
        return Math.max(prices[index] + findProfit(index + 1, 1, k - 1, prices),
                       findProfit(index + 1, 0, k, prices));
    }
}
