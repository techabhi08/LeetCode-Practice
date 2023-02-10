class Node{
    Node[] links = new Node[2];
    
    public Node(){}
    
    boolean containsKey(int num){
        return links[num] != null;
    }
    
    Node get(int num){
        return links[num];
    }
    
    void put(int num, Node node){
        links[num] = node;
    }
}

class Trie{
    private static Node root;
    
    public Trie(){
        root = new Node();
    }
    
    public void insert(int num){
        Node curr = root;
        for(int i = 31; i >= 0; i--){
            int currBit = (num >> i) & 1;
            if(!curr.containsKey(currBit)){
                curr.put(currBit, new Node());
            }
            curr = curr.get(currBit);
        }
    }
    
    public int getMax(int num){
        Node curr = root;
        int maxNum = 0;
        for(int i = 31; i >= 0; i--){
            int currBit = (num >> i) & 1;
            if(curr.containsKey(1 - currBit)){
                maxNum = maxNum | (1 << i);
                curr = curr.get(1 - currBit);
            }else{
                curr = curr.get(currBit);
            }
        }
        return maxNum;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        
        for(int num : nums){
            trie.insert(num);
        }
        
        int ans = 0;
        for(int num : nums){
            ans = Math.max(ans, trie.getMax(num));
        }
        
        return ans;
    }
}
