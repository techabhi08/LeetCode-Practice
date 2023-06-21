class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead2 = new int[2];
        int[] ahead = new int[2];
        int[] curr = new int[2];
        
        for(int index = n - 1; index >= 0; index--){
            curr[1] = Math.max(-prices[index] + ahead[0], ahead[1]);
            curr[0] = Math.max(prices[index] + (index + 2 <= n ? ahead2[1] : 0), ahead[0]);
            
            ahead2 = (int[])ahead.clone();
            ahead = (int[])curr.clone();
        }
        return ahead[1];
    }
}