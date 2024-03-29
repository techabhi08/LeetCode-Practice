class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        
        int[][] dp = new int[n + 1][n + 1];
        
        for(int j = 0; j <= n; j++){
            dp[0][j] = 0;
        }
        for(int j = 0; j <= n; j++){
            dp[j][0] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        return n - dp[n][n];
    }
}
