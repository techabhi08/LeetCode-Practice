class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findWays(0, n - 1, s, s, dp);
    }
    
    public int findWays(int i, int j, String s1, String s2, int[][] dp){
        if(i == s1.length() || j < 0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + findWays(i + 1, j - 1, s1, s2, dp);
        }
        
        return dp[i][j] = Math.max(findWays(i + 1, j, s1, s2, dp), findWays(i, j - 1, s1 , s2, dp));
    }
}
