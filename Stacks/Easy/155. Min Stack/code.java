class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val){
        if(minStack.empty() || val <= minStack.peek()){
            minStack.push(val);
        }
        stack.push(val);
    }
    
    public void pop(){
        if(stack.pop().equals(minStack.peek())){
            minStack.pop();
        }
    }
    
    public int top(){
        return stack.peek();
    }
    
    public int getMin(){
        return minStack.peek();
    }
//     int min = Integer.MAX_VALUE;
//     Stack<Integer> stack;

//     public MinStack() {
//         stack = new Stack<>();
//     }
    
//     public void push(int val) {
//         if(val <= min){
//             stack.push(min);
//             min = val;
//         }
//         stack.push(val);
//     }
    
//     public void pop() {
//         if(stack.pop() == min){
//             min = stack.pop();
//         }
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         return min;
//     }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
