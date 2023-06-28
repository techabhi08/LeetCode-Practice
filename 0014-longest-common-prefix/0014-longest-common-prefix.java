class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        
        for(int i = 1; i < n; i++){
            int j = 0;
            while(j < len && j < strs[i].length() && strs[i].charAt(j) == strs[i - 1].charAt(j)){
                j++;
            }
            len = j;
        }
        
        return strs[0].substring(0, len);
    }
}