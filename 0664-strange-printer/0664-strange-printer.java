class Solution {
    public int strangePrinter(String s) {
        int[][] dp = new int[s.length()][s.length()];
        return solve(s, 0, s.length() - 1, dp);
    }
    
    public int solve(String s, int i, int j, int[][] dp){
        if(i == j){
            return 1;
        }
        
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            ans = Math.min(ans, solve(s, i, k, dp) + solve(s, k + 1, j, dp));
        }
        
        return dp[i][j] = s.charAt(i) == s.charAt(j) ? ans - 1 : ans;
    }
}