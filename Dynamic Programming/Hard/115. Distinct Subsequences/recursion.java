class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        return findCount(n - 1, m - 1, s, t);
    }
    
    public int findCount(int i, int j, String s, String t){
        if(j < 0) return 1;
        if(i < 0) return 0;
        
        if(s.charAt(i) == t.charAt(j)){
            return findCount(i - 1, j - 1, s, t) + findCount(i - 1, j, s, t);
        }else{
            return findCount(i - 1, j, s, t);
        }
    }
}
