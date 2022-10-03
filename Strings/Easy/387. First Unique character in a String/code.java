class Solution {
    public int firstUniqChar(String s) {
        int[] charFreq = new int[26];
        for(char c : s.toCharArray()){
            charFreq[c - 'a']++;
        }
        
        int ans = -1;
        for(int i = 0; i < s.length(); i++){
            if(charFreq[s.charAt(i) - 'a'] == 1){
                ans = i;
                break;
            }
        }
        return ans;
    }
}
