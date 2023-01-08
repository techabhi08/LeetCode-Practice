class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int ans = 0;
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        
        for(int t = 0; t <= amount; t++){
            prev[t] = t % coins[0] == 0 ? t / coins[0] : (int)1e8;
        }
        
        for(int index = 1; index < n; index++){
            for(int a = 0; a <= amount; a++){
                int notTake = prev[a];
                int take = (int)1e8;
                if(coins[index] <= a){
                    take = 1 + curr[a - coins[index]];
                }
                curr[a] = Math.min(take, notTake);
            }
            prev = curr;
        }
        
        ans = prev[amount];
        return ans == 1e8 ? -1 : ans;
    }
}
