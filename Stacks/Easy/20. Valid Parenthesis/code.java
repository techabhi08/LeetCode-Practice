class Solution {
    public boolean isValid(String s) {
        // Using stack
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else if(stack.empty()){
                return false;
            }else if(ch == ')' && stack.pop() != '('){
                return false;
            }
            else if(ch == '}' && stack.pop() != '{'){
                return false;
            }
            else if(ch == ']' && stack.pop() != '['){
                return false;
            }
        }
        return stack.empty();
    }
}
