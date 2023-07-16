class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length; 
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        
        for(int i = 0; i <= amount; i++){
            prev[i] = i % coins[0] == 0 ? 1 : 0;
        }
        
        for(int index = 1; index < n; index++){
            for(int amt = 0; amt <= amount; amt++){
                int notTake = prev[amt];
                int take = 0;
                if(coins[index] <= amt){
                    take = curr[amt - coins[index]];
                }

                curr[amt] = take + notTake;
            }
            prev = (int[])curr.clone();
        }
        return prev[amount];
    }
}