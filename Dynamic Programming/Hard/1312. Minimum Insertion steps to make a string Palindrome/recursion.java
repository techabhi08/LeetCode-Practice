class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        
        return n - findLCS(n - 1, n - 1, s, s2);
    }
    
    public int findLCS(int i, int j, String s, String s2){
        if(i < 0 || j < 0){
            return 0;
        }
        
        if(s.charAt(i) == s2.charAt(j)){
            return 1 + findLCS(i - 1, j - 1, s, s2);
        }
        return Math.max(findLCS(i - 1, j, s, s2), findLCS(i, j - 1, s, s2));
    }
}
