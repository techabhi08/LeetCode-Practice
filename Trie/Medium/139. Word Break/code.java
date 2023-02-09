class Node {
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

class Solution {
    Set<Integer> visited = new HashSet<>();
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node();
        
        for(String word : wordDict){
            Node curr = root;
            for(char ch : word.toCharArray()){
                if(!curr.containsKey(ch)){
                    curr.put(ch, new Node());
                }
                curr = curr.get(ch);
            }
            curr.setEnd();
        }
        
        return isValidWordBreak(0, s, root);
    }
    
    
    public boolean isValidWordBreak(int index, String s, Node root){
        if(index == s.length()){
            return true;
        }
        
        if(visited.contains(index)){
            return false;
        }
        
        visited.add(index);
        
        Node curr = root;
        for(int i = index; i < s.length(); i++){
            curr = curr.get(s.charAt(i));
            
            if(curr == null){
                return false;
            }
            
            if(curr.isEnd() && isValidWordBreak(i + 1, s, root)){
                return true;
            }
        }
        return false;
    }
}
