class Solution {
    int lowest, maxLen;
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        
        for(int right = 0; right < s.length() - 1; right++){
            expandPalindrome(s, right, right);
            expandPalindrome(s, right, right + 1);
        }
        
        return s.substring(lowest, lowest + maxLen);
    }
    
    private void expandPalindrome(String s, int j, int k) {
	    while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
		    j--;
		    k++;
	    }
	    if (maxLen < k - j - 1) {
		    lowest = j + 1;
		    maxLen = k - j - 1;
	    }
    }
}