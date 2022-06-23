class Solution {
    public String longestCommonPrefix(String[] strs) {
        int ans = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            int j = 0;
            while(j < ans && j < strs[i].length() && 
                  (strs[i].charAt(j) == strs[i-1].charAt(j))){
                j++;
            }
            ans = j;
            
        }
        return strs[0].substring(0, ans);
        
    }
}
