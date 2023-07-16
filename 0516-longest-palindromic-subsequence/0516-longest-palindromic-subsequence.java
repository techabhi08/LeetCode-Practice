class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        
        int[][] dp = new int[len][len];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findMax(0, 0, s, s2, dp);
    }
    
    public int findMax(int i, int j, String s1, String s2, int[][] dp){
        if(i >= s1.length() || j >= s2.length()){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + findMax(i + 1, j + 1, s1, s2, dp);
        }
        return dp[i][j] = Math.max(findMax(i, j + 1, s1, s2, dp), findMax(i + 1, j, s1, s2, dp));
    }
}