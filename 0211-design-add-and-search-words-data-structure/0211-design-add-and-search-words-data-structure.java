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

class WordDictionary {
    Node root;
    
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
            if(!curr.contains(c)){
                curr.put(c, new Node());
            }
            curr = curr.get(c);
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
        return search(0, word, root);
    }
    
    public boolean search(int index, String word, Node root){
        if(root == null){
            return false;
        }
        if(index == word.length()){
            return root.isEnd();
        }
        
        char ch = word.charAt(index);
        if(ch == '.'){
            for(Node child : root.links){
                if(search(index + 1, word, child)){
                    return true;
                }
            }
        }else{
            if(search(index + 1, word, root.get(ch))){
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