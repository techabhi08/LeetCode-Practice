class Solution {
    public int minimizeConcatenatedLength(String[] words) {
        int n = words.length;
        
        if(n == 1){
            return words[0].length();
        }
        
        int s = words[0].charAt(0) - 'a';
        int e = words[0].charAt(words[0].length() - 1) - 'a';
        int[][][] dp = new int[n][26][26];
        for(int[][] rows : dp){
            for(int[] row : rows){
                Arrays.fill(row, -1);
            }
        }
        
        return findMin(1, n, s, e, words, dp) + words[0].length();
    }
    
    public int findMin(int i, int n, int s, int e, String[] words, int[][][] dp){
        if(i == n){
            return 0;
        }
        
        if(dp[i][s][e] != -1){
            return dp[i][s][e];
        }
        
        String curr = words[i];
        int cs = curr.charAt(0) - 'a';
        int ce = curr.charAt(curr.length() - 1) - 'a';
        
        int len1 = curr.length();
        int len2 = curr.length();
        
        if(e == cs){
            len1--;
        }
        if(s == ce){
            len2--;
        }
        
        return dp[i][s][e] = Math.min(findMin(i + 1, n, cs, e, words, dp) + len2, findMin(i + 1, n, s, ce, words, dp) + len1);
    }
}