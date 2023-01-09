class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        return findWays(0, n - 1, s, s);
    }
    
    public int findWays(int i, int j, String s1, String s2){
        if(i == s1.length() || j < 0){
            return 0;
        }
        
        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + findWays(i + 1, j - 1, s1, s2);
        }
        return Math.max(findWays(i + 1, j, s1, s2), findWays(i, j - 1, s1 , s2));
    }
}
