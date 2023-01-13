class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return n + m - 2 * findLCS(n - 1, m - 1, word1, word2, dp);
    }
    
    public int findLCS(int i, int j, String s1, String s2, int[][] dp){
        if(i < 0 || j < 0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + findLCS(i - 1, j - 1, s1, s2, dp);
        }
        return dp[i][j] = Math.max(findLCS(i - 1, j, s1, s2, dp), findLCS(i, j - 1, s1, s2, dp));
    }
}
