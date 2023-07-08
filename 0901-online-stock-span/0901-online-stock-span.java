class StockSpanner {
    Stack<int[]> stack1;

    public StockSpanner() {
        stack1 = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        while(!stack1.isEmpty() && stack1.peek()[0] <= price){
            count += stack1.pop()[1];
        }
        stack1.push(new int[]{price, count});
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */