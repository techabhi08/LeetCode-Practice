class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findMatch(n - 1, m - 1, s, p, dp) == 1 ? true : false;
    }
    
    public int findMatch(int i, int j, String s, String p, int[][] dp){
        if(j < 0 && i < 0){
            return 1;
        }
        if(j < 0 && i >= 0){
            return 0;
        }
        if(i < 0 && j >= 0){
            for(int k = 0; k <= j; k++){
                if(p.charAt(k) != '*'){
                    return 0;
                }
            }
            return 1;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = findMatch(i - 1, j - 1, s, p, dp);
        }else if(p.charAt(j) == '*'){
            return dp[i][j] = (findMatch(i - 1, j, s, p, dp) == 1 || findMatch(i, j - 1, s, p, dp) == 1) ? 1 : 0;
        }
        return 0;
    }
}
