class Solution {
    public String removeTrailingZeros(String num) {
        boolean isNum = false;
        int count = 0;
        for(char c : num.toCharArray()){
            if(c == '0' && isNum){
                count++;
            }else{
                isNum = true;
                count = 0;
            }
        }
        
        return num.substring(0, num.length() - count);
    }
}