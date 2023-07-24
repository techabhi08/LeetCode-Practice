class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int value = roman(ch);
            if(i + 1 < s.length() && roman(s.charAt(i + 1)) > value){
                ans -= value;
            }else{
                ans += value;
            }
        }
        return ans;
    }
    
    public int roman(char c){
        switch(c){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
}