class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            if((i + 1 < s.length()) && value(s.charAt(i)) < value(s.charAt(i+1))){
                sum -= value(s.charAt(i));
            }else{
                sum += value(s.charAt(i));
            }
        }
        return sum;
    }
    
    public int value(char ch){
        switch(ch){
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
