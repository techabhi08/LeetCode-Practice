class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            if((i + 1 < s.length()) && findValue(s.charAt(i)) < findValue(s.charAt(i + 1))){
                sum -= findValue(s.charAt(i));
            }else{
                sum += findValue(s.charAt(i));
            }
        }
        return sum;
    }
    
    public int findValue(char c){
        switch(c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
