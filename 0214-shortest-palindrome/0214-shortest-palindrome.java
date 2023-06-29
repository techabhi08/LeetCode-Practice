class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        
        String str = s + "#" + rev;
        
        int n = str.length();
        char[] pat = str.toCharArray();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        
        while(i < n){
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
        
        int ans = lps[n - 1];
        String appendString = rev.substring(0, rev.length() - ans);
        
        return appendString + "" + s;
    }
}