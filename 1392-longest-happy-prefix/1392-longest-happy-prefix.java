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
                if(len == 0){
                    lps[i] = 0;
                    i++;
                }else{
                    len = lps[len - 1];
                }
            }
        }
        
        return s.substring(0, lps[lps.length - 1]);
    }
}