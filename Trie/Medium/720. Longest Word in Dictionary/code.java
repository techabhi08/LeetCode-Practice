class Node{
    Node[] links = new Node[26];
    boolean flag = false;
    
    public Node(){
        
    }
    
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
    
    public static void insert(String word){
        Node curr = root;
        
        //Inserting each word into the Trie
        for(char ch : word.toCharArray()){
            if(!curr.containsKey(ch)){
                curr.put(ch, new Node());
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    boolean checkIfPrefixExists(String word){
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(curr.containsKey(ch)){
                curr = curr.get(ch);
                if(curr.isEnd() == false){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }
        
        String longest = "";
        for(String word : words){
            if(trie.checkIfPrefixExists(word)){
                if(word.length() > longest.length()){
                    longest = word;
                }else if(word.length() == longest.length() && word.compareTo(longest) < 0){
                    longest = word;
                }
            }
        }
        
        return longest;
    }
}
