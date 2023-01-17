class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        return findCount(n - 1, m - 1, word1, word2);
    }
    
    public int findCount(int i, int j, String word1, String word2){
        if(j < 0) return i + 1;
        if(i < 0) return j + 1;
        
        if(word1.charAt(i) == word2.charAt(j)){
            return findCount(i - 1, j - 1, word1, word2);
        }
        
        return Math.min(1 + findCount(i - 1, j, word1, word2), Math.min(1 + findCount(i, j - 1, word1, word2), 1 + findCount(i - 1, j - 1, word1, word2)));
    }
}
