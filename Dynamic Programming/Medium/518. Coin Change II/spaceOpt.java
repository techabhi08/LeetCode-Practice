class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        
        for(int i = 0; i <= amount; i++){
            prev[i] = i % coins[0] == 0 ? 1 : 0;
        }
        
        for(int index = 1; index < n; index++){
            for(int tar = 0; tar <= amount; tar++){
                int take = 0;
                if(coins[index] <= tar){
                    take = curr[tar - coins[index]];
                }
                int notTake = prev[tar];
                curr[tar] = take + notTake;
            }
            prev = (int[])curr.clone();
        }
        return prev[amount];
    }
}
