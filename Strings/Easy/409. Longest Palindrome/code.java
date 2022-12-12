class Solution {
    public int longestPalindrome(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        
        int[] count = new int[128];
        for(char c : s.toCharArray()){
            count[c]++;
        }
        
        int ans = 0;
        for(int num : count){
            if(num % 2 == 0){
                ans += num;
            }else{
                ans += num - 1;
            }
        }
        
        if(ans % 2 == 0 && ans < s.length()){
            ans += 1;
        }
        return ans;
    }
}
