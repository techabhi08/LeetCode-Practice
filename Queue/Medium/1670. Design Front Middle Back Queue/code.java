class FrontMiddleBackQueue {
    ArrayList<Integer> list;
    int front = 0;
    int end = 0;

    public FrontMiddleBackQueue() {
        list = new ArrayList<>();
    }
    
    public void pushFront(int val) {
        list.add(0, val);
    }
    
    public void pushMiddle(int val) {
        list.add(list.size() / 2, val);
    }
    
    public void pushBack(int val) {
        list.add(val);
    }
    
    public int popFront() {
        if(list.isEmpty()){
            return -1;
        }
        return list.remove(0);
    }
    
    public int popMiddle() {
        if(list.isEmpty()){
            return -1;
        }
        return list.remove((list.size() - 1)/ 2);
    }
    
    public int popBack() {
        if(list.isEmpty()){
            return -1;
        }
        return list.remove(list.size() - 1);
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
