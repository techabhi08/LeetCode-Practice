class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return (n + m) - (2 * findLCS(n - 1, m - 1, word1, word2, dp));
    }
    
    public int findLCS(int n, int m, String word1, String word2, int[][] dp){
        if(n < 0 || m < 0){
            return 0;
        }
        
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        
        if(word1.charAt(n) == word2.charAt(m)){
            return dp[n][m] = 1 + findLCS(n - 1, m - 1, word1, word2, dp);
        }
        return dp[n][m] = Math.max(findLCS(n - 1, m, word1, word2, dp), findLCS(n, m - 1, word1, word2, dp));
    }
}