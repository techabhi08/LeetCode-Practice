class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i] = -1;
        }
        
        if(n <= 2){
            return n;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }
}
