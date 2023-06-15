class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int max = 0;
        int count = 0;
        int left = 0;
        
        for(int right = 0; right < s.length(); right++){
            if(right > 0 && s.charAt(right) == s.charAt(right - 1)){
                count++;
            }
            
            while(count > 1){
                if(right > left && s.charAt(left) == s.charAt(left + 1)){
                    count--;
                }
                left++;
            }
            
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}