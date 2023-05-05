class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        Arrays.fill(ans, -1);
        
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] <= prices[i]){
                    ans[i] = prices[i] - prices[j];
                    break;
                }
            }
            if(ans[i] == -1){
                ans[i] = prices[i];
            }
        }
        return ans;
    }
}
