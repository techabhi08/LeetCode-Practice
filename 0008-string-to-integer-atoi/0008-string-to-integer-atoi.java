class Solution {
    public int myAtoi(String s) {
        if(s.equals("")){
            return 0;
        }
        
        int ans = 0;
        int i = 0;
        int sign = 1;
        
        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        
        if(i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            if(s.charAt(i++) == '-'){
                sign = -1;
            }
        }
        
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)){
                if(sign == -1){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }
            ans = ans * 10 + (s.charAt(i++) - '0');
        }
        
        return sign * ans;
    }
}