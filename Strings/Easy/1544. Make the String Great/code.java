class Solution {
    public String makeGood(String s) {
        if(s.length() <= 1){
            return s;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && Math.abs(stack.peek() - s.charAt(i)) == 32){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(String.valueOf(stack.pop()));
        }
        return sb.reverse().toString();
    }
}
