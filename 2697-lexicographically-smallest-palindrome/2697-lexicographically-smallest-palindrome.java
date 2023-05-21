class Solution {
    public String makeSmallestPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        char[] str = s.toCharArray();
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                if(s.charAt(i) < s.charAt(j)){
                    str[j] = s.charAt(i);
                }else{
                    str[i] = s.charAt(j);
                }
                i++;
                j--;
            }
        }
        
        return new String(str);
    }
}