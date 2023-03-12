class Solution {
    public String toHex(int num) {
        if(num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        
        boolean negative = num < 0 ? true : false;
        num = num < 0 ? (num + 1) * -1 : num;
        
        while(num != 0){
            int temp = num % 16;
            if(negative){
                temp = 15 - temp;
            }
            
            char ch = (char)(temp < 10 ? temp + '0' : temp - 10 + 'a');
            sb.append(ch);
            
            num /= 16;
        }
        
        if(negative){
            while(sb.length() < 8){
                sb.append('f');
            }
        }
        
        return sb.reverse().toString();
    }
}
