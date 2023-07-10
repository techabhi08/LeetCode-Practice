class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        return findStairs(n, dp);
    }
    
    public int findStairs(int n, int[] dp){
        if(n <= 2){
            return n;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        return dp[n] = findStairs(n - 1, dp) + findStairs(n - 2, dp);
    }
}