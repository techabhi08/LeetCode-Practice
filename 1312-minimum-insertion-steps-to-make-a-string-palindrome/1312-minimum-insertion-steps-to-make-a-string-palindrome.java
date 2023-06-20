class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return n - findLCS(n - 1, n - 1, s, s2, dp);
    }
    
    public int findLCS(int i, int j, String s, String s2, int[][] dp){
        if(i < 0 || j < 0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + findLCS(i - 1, j - 1, s, s2, dp);
        }
        return dp[i][j] = Math.max(findLCS(i - 1, j, s, s2, dp), findLCS(i, j - 1, s, s2, dp));
    }
}