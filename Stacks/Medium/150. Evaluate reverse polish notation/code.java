class Solution {
    public int evalRPN(String[] tokens) {
        int num1, num2;
		Stack<Integer> stack = new Stack<Integer>();
		for (String s : tokens) {
			if(s.equals("+")) {
				stack.add(stack.pop() + stack.pop());
			}
			else if(s.equals("/")) {
				num2 = stack.pop();
				num1 = stack.pop();
				stack.add(num1 / num2);
			}
			else if(s.equals("*")) {
				stack.add(stack.pop() * stack.pop());
			}
			else if(s.equals("-")) {
				num2 = stack.pop();
				num1 = stack.pop();
				stack.add(num1 - num2);
			}
			else {
				stack.add(Integer.parseInt(s));
			}
		}	
		return stack.pop();
    }
}
