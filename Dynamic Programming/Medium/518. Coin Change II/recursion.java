class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        return findWays(n - 1, coins, amount);
    }
    
    public int findWays(int index, int[] coins, int target){
        if(index == 0){
            return target % coins[0] == 0 ? 1 : 0;
        }
        
        if(target == 0){
            return 1;
        }
        
        int notTake = findWays(index - 1, coins, target);
        int take = 0;
        if(coins[index] <= target){
            take = findWays(index, coins, target - coins[index]);
        }
        
        return take + notTake;
    }
}
