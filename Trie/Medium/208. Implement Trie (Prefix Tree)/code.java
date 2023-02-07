class Node {
    Node[] links = new Node[26];
    boolean flag = false;
    
    public Node() {
        
    }
    
    boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }
    
    Node get(char ch){
        return links[ch - 'a'];
    }
    
    void put(char ch, Node node){
        links[ch - 'a'] = node;
    }
    
    void setEnd(){
        flag = true;
    }
    
    boolean isEnd() {
        return flag;
    }
}

class Trie {
    private static Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!curr.containsKey(ch)){
                curr.put(ch, new Node());
            }
            //now we move to the reference Trie.
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!curr.containsKey(ch)){
                return false;
            }
            curr = curr.get(ch);
        }
        if(curr.isEnd()){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!curr.containsKey(ch)){
                return false;
            }
            curr = curr.get(ch);
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
