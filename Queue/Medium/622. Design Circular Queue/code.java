class MyCircularQueue {
    int[] data;
    int size = 0;
    int front = 0;
    int end = -1;

    public MyCircularQueue(int k) {
        this.data = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        end = (end + 1) % data.length;
        data[end] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % data.length;
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[end];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == data.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
