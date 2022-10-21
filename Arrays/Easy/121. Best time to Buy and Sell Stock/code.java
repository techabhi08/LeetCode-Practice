class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(min < prices[i]){
                profit = Math.max(prices[i] - min, profit);
            }else{
                min = prices[i];
            }
        }
        return profit;
    }
}
