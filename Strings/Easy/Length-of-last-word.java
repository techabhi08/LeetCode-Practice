class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        String p = s.trim();
        
        for(int i = p.length() - 1; i >= 0; i--){
            if(p.charAt(i) == ' '){
                break;
            }else{
                ans++;
            }
        }
        
        return ans;
    }
}
