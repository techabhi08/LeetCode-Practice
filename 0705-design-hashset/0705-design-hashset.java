class MyHashSet {
    boolean[] keys;
    
    public MyHashSet() {
        keys = new boolean[1000001];
    }
    
    public void add(int key) {
        keys[key] = true;
    }
    
    public void remove(int key) {
        keys[key] = false;
    }
    
    public boolean contains(int key) {
        return keys[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */