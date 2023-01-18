class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        // Base case - 1
        dp[0][0] = true;
        //Base case - 2 No need actually bcoz all the values are false by default
        for(int i = 1; i <= n; i++){
            dp[i][0] = false;
        }
        for(int j = 1; j <= m; j++){
            boolean flag = true;
            for(int k = 1; k <= j; k++){
                if(p.charAt(k - 1) != '*'){
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[n][m];
    }
}
