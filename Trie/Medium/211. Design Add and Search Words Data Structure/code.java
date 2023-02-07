class Node {
    Node[] links = new Node[26];
    boolean flag = false;
    
    public Node(){
        
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
    
    boolean isEnd(){
        return flag;
    }
}
class WordDictionary {
    private static Node root;
    
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!curr.containsKey(ch)){
                curr.put(ch, new Node());
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    public boolean search(String word, int i, Node root){
        if(root == null){
            return false;
        }
        if(i == word.length()){
            return root.isEnd();
        }
        
        char ch = word.charAt(i);
        if(ch == '.'){
            for(Node child : root.links){
                if(search(word, i + 1, child)){
                    return true;
                }
            }
        }else{
            if(search(word, i + 1, root.get(ch))){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
