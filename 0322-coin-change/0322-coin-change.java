class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            prev[i] = i % coins[0] == 0 ? i / coins[0] : (int)1e8;
        }
        
        
        for(int index = 1; index < n; index++){
            for(int target = 1; target <= amount; target++){
                int notTake = prev[target];
                int take = (int)1e8;
                if(coins[index] <= target){
                    take = 1 + curr[target - coins[index]];
                }

                curr[target] = Math.min(take, notTake);
            }
            prev = (int[])curr.clone();
        }
        int ans = prev[amount];
        return ans == (int)1e8 ? -1 : ans;
    }
}