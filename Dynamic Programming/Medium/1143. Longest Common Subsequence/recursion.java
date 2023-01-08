class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        return findLCS(n - 1, m - 1, text1, text2);
    }
    
    public int findLCS(int i, int j, String s1, String s2){
        if(i < 0 || j < 0){
            return 0;
        }
        
        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + findLCS(i - 1, j - 1, s1, s2);
        }
        return Math.max(findLCS(i - 1, j, s1, s2), findLCS(i, j - 1, s1, s2));
    }
    
}
