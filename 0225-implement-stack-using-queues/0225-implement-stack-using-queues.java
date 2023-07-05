class MyStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        while(!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        queue1.add(x);
        while(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        return queue1.poll();
    }
    
    public int top() {
        if(empty()){
            return -1;
        }
        int ans = queue1.peek();
        return ans;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */