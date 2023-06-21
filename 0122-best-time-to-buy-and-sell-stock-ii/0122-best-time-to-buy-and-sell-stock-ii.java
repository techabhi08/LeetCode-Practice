class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] next = new int[2];
        int[] curr = new int[2];
        next[0] = 0;
        next[1] = 0;
        
        for(int index = n - 1; index >= 0; index--){
            curr[1] = Math.max(-prices[index] + next[0], next[1]);
            curr[0] = Math.max(prices[index] + next[1], next[0]);
            
            next = (int[])curr.clone();
        }
        return next[1];
    }
}