class Solution {
    public String longestPrefix(String s) {
        int m = s.length();
        int len = 0;
        int i = 1;
        int[] lps = new int[m];
        lps[0] = 0;
        char[] pat = s.toCharArray();
        
        while(i < m){
            if(pat[i] == pat[len]){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len - 1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return s.substring(0, lps[s.length() - 1]);
    }
}