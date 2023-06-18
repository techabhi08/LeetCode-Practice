class Solution {
    public int coinChange(int[] coins, int amt) {
        int n = coins.length;
        Arrays.sort(coins);
        int[] prev = new int[amt + 1];
        int[] curr = new int[amt + 1];
        
        for(int i = 0; i <= amt; i++){
            prev[i] = i % coins[0] == 0 ? i / coins[0] : (int)1e8;
        }
        
        for(int index = 1; index < n; index++){
            for(int amount = 0; amount <= amt; amount++){
                int notTake = prev[amount];
                int take = (int)1e8;
                if(coins[index] <= amount){
                    take = 1 + curr[amount - coins[index]];
                }

                curr[amount] = Math.min(take, notTake);
            }
            prev = curr;
        }
        
        int ans = prev[amt];
        return ans == (int)1e8 ? -1 : ans;
    }
    
}