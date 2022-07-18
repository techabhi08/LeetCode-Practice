class MyLinkedList {
    Node head;
    int size;
    
    class Node{
        int val;
        Node next;
        
        public Node(int val){
            this.val = val;
        }
    }
    
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        Node node = head;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node.val;
    }
    
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }
    
    public void addAtTail(int val) {
        if(head == null){
            addAtHead(val);
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            Node node = new Node(val);
            temp.next = node;
            size++;
        } 
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index == 0){
            addAtHead(val);
        }
        else{
            Node temp = head;
            Node prev = null;
            for(int i = 0; i < index; i++){
                prev = temp;
                temp = temp.next;
            }
            Node node  = new Node(val);
            prev.next = node;
            node.next = temp;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size){
            return;
        }
        if(index == 0){
            head = head.next;
            size--;
        }else{
            Node temp = head;
            Node prev = null;
            for(int i = 0; i < index; i++){
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
            size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
