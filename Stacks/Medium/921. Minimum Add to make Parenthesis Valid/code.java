class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.empty() && c == ')' && stack.peek() == '('){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.size();
    }
}
