class Node{
    Node prev;
    Node next;
    int val, key;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            remove(curr);
            insert(curr);
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(capacity == map.size()){
            remove(tail.prev);
        }
        insert(node);
    }
    
    public void insert(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    public void remove(Node node){
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */