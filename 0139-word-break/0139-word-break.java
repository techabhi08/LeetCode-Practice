class Node{
    Node[] links = new Node[26];
    boolean flag = false;
    
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

class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node();
        
        for(String word : wordDict){
            Node curr = root;
            for(char ch : word.toCharArray()){
                if(!curr.contains(ch)){
                    curr.put(ch, new Node());
                }
                curr = curr.get(ch);
            }
            curr.setEnd();
        }
        
        return isValidBreak(0, s, root);
    }
    
    public boolean isValidBreak(int index, String s, Node root){
        if(index == s.length()){
            return true;
        }
        
        if(set.contains(index)){
            return false;
        }
        
        set.add(index);
        Node curr = root;
        
        for(int i = index; i < s.length(); i++){
            curr = curr.get(s.charAt(i));
            
            if(curr == null){
                return false;
            }
            
            if(curr.isEnd() && isValidBreak(i + 1, s, root)){
                return true;
            }
        }
        return false;
    }
}