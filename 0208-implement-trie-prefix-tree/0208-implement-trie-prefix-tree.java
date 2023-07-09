class Node{
    Node[] links = new Node[26];
    boolean flag;
    
    Node(){}
    
    public boolean contains(char ch){
        return links[ch - 'a'] != null;
    }
    
    public Node get(char ch){
        return links[ch - 'a'];
    }
    
    public void put(char ch, Node node){
        links[ch - 'a'] = node;
    }
    
    public boolean isEnd(){
        return flag;
    }
    
    public void setEnd(){
        flag = true;
    }
}

class Trie {
    private static Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            if(!node.contains(c)){
                node.put(c, new Node());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            if(!node.contains(c)){
                return false;
            }
            node = node.get(c);
        }
        if(node.isEnd()){
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c : prefix.toCharArray()){
            if(!node.contains(c)){
                return false;
            }
            node = node.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */