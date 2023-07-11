class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return findCount(0, s, dp);
    }
    
    public int findCount(int index, String s, int[] dp){
        if(index == s.length()){
            return 1;
        }
        if(s.charAt(index) == '0'){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int res = findCount(index + 1, s, dp);
        if(index < s.length() - 1 && (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) < '7'))){
            res += findCount(index + 2, s, dp);
        }
        return dp[index] = res;
    }
}