class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            String curr = strs[i];
            int j = 0;
            while(j < len && j < curr.length() && curr.charAt(j) == strs[i - 1].charAt(j)){
                j++;
            }
            len = j;
        }
        return strs[0].substring(0, len);
    }
}