class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int aheadNotBuy = 0;
        int aheadBuy = 0;
        int currBuy, currNotBuy;
        
        for(int index = n - 1; index >= 0; index--){
            currBuy = Math.max(-prices[index] + aheadNotBuy, aheadBuy);
            currNotBuy = Math.max(prices[index] + aheadBuy, aheadNotBuy);
            
            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadBuy;
    }
}
