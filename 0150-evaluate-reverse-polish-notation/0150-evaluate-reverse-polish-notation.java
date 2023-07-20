class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens){
            if(str.equals("*")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = num1 * num2;
                stack.push(res);
            }else if(str.equals("+")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1 + num2);
            }else if(str.equals("-")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 - num2);
            }else if(str.equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 / num2);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}