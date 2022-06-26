class Solution {
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            
            if(ch == '(' || ch == '{' || ch == '['){
                sb.append(ch);
            }else{
                if(ch == ')' || ch == '}' || ch == ']'){
                    if(sb.length() > 0){
                        char t = sb.charAt(sb.length() - 1);
                        if(ch =='}' && t != '{' || ch == ']' && t != '[' ||
                           ch == ')' && t != '(') {
                            return false;
                        }else{
                            sb.deleteCharAt(sb.length() - 1);
                        }
                    }else{
                        return false;
                    }
                }
            }
        }
        return sb.length() == 0;
    }
}
