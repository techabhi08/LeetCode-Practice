class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        return n + m - 2 * findLCS(n - 1, m - 1, word1, word2);
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
