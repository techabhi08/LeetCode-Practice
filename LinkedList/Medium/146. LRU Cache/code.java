import java.util.Hashtable;
class LRUCache {
    class DLL{
        int key;
        int val;
        DLL prev;
        DLL next;
    }
    
    DLL head;
    DLL tail;
    private Hashtable<Integer, DLL> cache = new Hashtable<Integer, DLL>();
    int count;
    int capacity;
    
    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        
        head = new DLL();
        tail = new DLL();
        
        head.prev = null;
        head.next = tail;
        tail.next = null;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        DLL node = cache.get(key);
        if(node == null){
            return -1;
        }else{
            moveToHead(node);
        }
        return node.val;
    }
    
    public void put(int key, int value) {
        DLL node = cache.get(key);
        if(node == null){
            DLL newNode  = new DLL();
            newNode.key = key;
            newNode.val = value;
            
            cache.put(key, newNode);
            insertNode(newNode);
            count++;
            
            if(count > capacity){
                DLL tail = removeTail();
                cache.remove(tail.key);
                count--;
            }
        }else{
            node.val = value;
            moveToHead(node);
        }
    }
    
    public void insertNode(DLL node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
       head.next = node;
    }
    
    private void removeNode(DLL node){
        DLL pre = node.prev;
        DLL nex = node.next;
        
        pre.next = nex;
        nex.prev = pre;
    }
    
    private void moveToHead(DLL node){
        removeNode(node);
        insertNode(node);
    }
    
    private DLL removeTail(){
        DLL temp = tail.prev;
        removeNode(temp);
        return temp;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
