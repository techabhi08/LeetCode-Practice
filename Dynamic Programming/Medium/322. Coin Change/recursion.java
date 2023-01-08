class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int ans = 0;
        ans = findChange(n - 1, coins, amount);
        return ans == 1e8 ? -1 : ans;
    }
    
    public int findChange(int index, int[] coins, int amount){
        if(index == 0){
            if(amount % coins[index] == 0){
                return amount / coins[index];
            }else{
                return (int)1e8;
            }
        }
        
        int notTake = findChange(index - 1, coins, amount);
        int take = (int)1e8;
        if(coins[index] <= amount){
            take = 1 + findChange(index, coins, amount - coins[index]);
        }
        
        return Math.min(take, notTake);
    }
}
