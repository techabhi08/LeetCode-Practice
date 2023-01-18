class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        
        return findMatch(n - 1, m - 1, s, p);
    }
    
    public boolean findMatch(int i, int j, String s, String p){
        if(j < 0 && i < 0){
            return true;
        }
        if(j < 0 && i >= 0){
            return false;
        }
        if(i < 0 && j >= 0){
            for(int k = 0; k <= j; k++){
                if(p.charAt(k) != '*'){
                    return false;
                }
            }
            return true;
        }
        
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return findMatch(i - 1, j - 1, s, p);
        }else if(p.charAt(j) == '*'){
            return findMatch(i - 1, j, s, p) || findMatch(i, j - 1, s, p);
        }
        return false;
    }
}
