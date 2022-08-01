class CustomStack {
    int[] stack;
    int temp = 0;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
    }
    
    public void push(int x) {
        if(temp < stack.length){
            stack[temp] = x;
            temp++;
        }
    }
    
    public int pop() {
        if(temp == 0){
            return -1;
        }
        temp--;
        return stack[temp];
    }
    
    public void increment(int k, int val) {
        if(stack.length == 0){
            return;
        }
        for(int i = 0; i < k && i < stack.length; i++){
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
