class MyQueue {
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    
    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }
    
    public void push(int x) {
        stk1.push(x);
    }
    
    public int pop() {
        if(stk2.empty()){
            while(!stk1.empty()){
                stk2.push(stk1.pop());
            }
        }
        return stk2.pop();
    }
    
    public int peek() {
        if(stk2.empty()){
            while(!stk1.empty()){
                stk2.push(stk1.pop());
            }
        }
        return stk2.peek();
    }
    
    public boolean empty() {
        return stk1.empty() && stk2.empty();
    }
    
    
    //Method 2
//     Stack<Integer> stk1;
//     Stack<Integer> stk2;
    
//     public MyQueue() {
//         stk1 = new Stack<>();
//         stk2 = new Stack<>();
//     }
    
//     public void push(int x) {
//         while(!stk1.empty()){
//             stk2.push(stk1.pop());
//         }
//         stk1.push(x);
//         while(!stk2.empty()){
//             stk1.push(stk2.pop());
//         }
//     }
    
//     public int pop() {
//         return stk1.pop();
//     }
    
//     public int peek() {
//         return stk1.peek();
//     }
    
//     public boolean empty() {
//         return stk1.empty();
//     }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
