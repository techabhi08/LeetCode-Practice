class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == ']'){
                StringBuilder inner = new StringBuilder();
                String digit = new String();
                int num;
                
                while(!stack.isEmpty() && stack.peek() != '['){
                    inner.append(stack.pop());
                }
                stack.pop();
                
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    digit = stack.pop() + digit;
                }
                num = Integer.parseInt(digit);
                
                while(num-- != 0){
                    for(int i = inner.length() - 1; i >= 0; i--){
                        stack.push(inner.charAt(i));
                    }
                }
            }else{
                stack.push(c);
            }
        }
        char[] ans = new char[stack.size()];
        int i = stack.size() - 1;
        while(!stack.empty()){
            ans[i--] = stack.pop();
        }
        return new String(ans);
    }
}
