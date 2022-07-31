class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(stack.size() >= 1){
                    sb.append(ch);
                }
                stack.push(ch);
            }else{
                if(stack.size() > 1){
                    sb.append(ch);
                }
                stack.pop();
            }
        }
        
        return sb.toString();
    }
}
