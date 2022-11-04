class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for(char c : number.toCharArray()){
            if(c != ' ' && c != '-'){
                sb.append(c);
            }
        }
        
        String num = sb.toString();
        
        StringBuilder ans = new StringBuilder();
        
        int count = num.length();
        int start = 0;
        while(count > 4){
            ans.append(num.substring(start, start + 3));
            count -= 3;
            start += 3;
            ans.append('-');
        }
        if(count < 4){
            ans.append(num.substring(start));
        }else{
            ans.append(num.substring(start, start + 2));
            count -= 2;
            start += 2;
            ans.append('-');
            ans.append(num.substring(start, start + 2));
        }
        return ans.toString();
    }
}
