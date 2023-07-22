class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int[] count = new int[3];
        int left = 0;
        
        for(int i = 0; i < s.length(); i++){
            int ch = s.charAt(i) - 'a';
            count[ch]++;
            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                ans += s.length() - i;
                int c = s.charAt(left) - 'a';
                count[c]--;
                left++;
            }
        }
        return ans;
    }
}