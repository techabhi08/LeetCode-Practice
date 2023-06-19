class Solution {
    public int longestPalindromeSubseq(String s1) {
        int n = s1.length();
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();
        
        int[][] dp = new int[n + 1][n + 1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n ; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    
                }
            }
        }
        return dp[n][n];
    }
}