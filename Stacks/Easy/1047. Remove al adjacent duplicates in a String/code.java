class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(stack.size() >= 1){
                if(stack.peek() == ch){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }else{
                stack.push(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(stack.size() != 0){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}
