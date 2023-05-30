class MyHashMap {
    List<Integer> keys;
    List<Integer> values;
    
    public MyHashMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        if(!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else{
            int index = keys.indexOf(key);
            values.set(index, value);
        }
    }
    
    public int get(int key) {
        if(!keys.contains(key)){
            return -1;
        }
        int index = keys.indexOf(key);
        return values.get(index);
    }
    
    public void remove(int key) {
        if(!keys.contains(key)){
            return;
        }
        int index = keys.indexOf(key);
        values.remove(index);
        keys.remove(index);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */