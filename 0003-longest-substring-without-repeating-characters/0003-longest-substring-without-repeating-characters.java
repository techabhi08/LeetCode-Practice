class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        int left = 0;
        int ans = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);    
            if(set.contains(ch)){
                while(left < i && set.contains(ch)){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(ch);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}