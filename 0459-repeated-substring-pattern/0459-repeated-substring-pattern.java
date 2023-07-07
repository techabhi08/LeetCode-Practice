class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String ans = s + s;
        if(ans.substring(1, ans.length() - 1).contains(s)){
            return true;
        }
        return false;
    }
}