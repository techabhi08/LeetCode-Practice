class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        
        for(int i = 0; i < s1.length(); i++){
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }
        
        if(Arrays.equals(s1Freq, s2Freq)){
            return true;
        }
        
        for(int i = s1.length(); i < s2.length(); i++){
            s2Freq[s2.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i - s1.length()) - 'a']--;
            if(Arrays.equals(s1Freq, s2Freq)){
                return true;
            }
        }
        return false;
    }
}
