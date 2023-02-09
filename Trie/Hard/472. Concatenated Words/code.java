class Node{
    Node[] links = new Node[26];
    boolean flag = false;
    
    public Node(){}
    
    boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }
    
    void put(char ch, Node node){
        links[ch - 'a'] = node;
    }
    
    Node get(char ch){
        return links[ch - 'a'];
    }
    
    void setEnd(){
        flag = true;
    }
    
    boolean isEnd(){
        return flag;
    }
}

class Trie {
    private static Node root;
    
    public Trie(){
        root = new Node();
    }
    
    public void insert(String word){
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(!curr.containsKey(ch)){
                curr.put(ch, new Node());
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    public boolean findIfConcatenated(String word, int index, int count){
        Node curr = root;
        for(int i = index; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!curr.containsKey(ch)){
                return false;
            }
            curr = curr.get(ch);
            if(curr.isEnd() && findIfConcatenated(word, i + 1, count + 1)){
                return true;
            }
        }
        return count >= 1 && curr.isEnd();
    }
}

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }
        
        List<String> ans = new ArrayList<>();
        for(String word : words){
            if(trie.findIfConcatenated(word, 0, 0)){
                ans.add(word);
            }
        }
        return ans;
    }
}
