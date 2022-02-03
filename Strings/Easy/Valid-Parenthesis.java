class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        char stk[] = new char[len];
        int top = -1;
        
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stk[++top] = c;
            }else{
                if(c == ')' || c == '}' ||c == ']'){
                    if(top >= 0){
                        char t = stk[top];
                        if(c=='}' && t!='{'
                            ||c==']' && t!='['
                            ||c==')' && t!='(') {
                            return false;
                        }else{
                            --top;
                        }
                    }else{
                        return false;
                    }
                }
            }
        }
        return top < 0;
    }
}
