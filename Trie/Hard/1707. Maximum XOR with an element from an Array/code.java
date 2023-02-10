class Node {
    Node[] links = new Node[2];
    
    public Node(){}
    
    boolean containsKey(int bit){
        return links[bit] != null;
    }
    
    void put(int bit, Node node){
        links[bit] = node;
    }
    
    Node get(int bit){
        return links[bit];
    }
}

class Trie {
    private Node root;
    
    public Trie(){
        root = new Node();
    }
    
    public void insert(int bit){
        Node curr = root;
        for(int i = 31; i >= 0; i--){
            int currBit = (bit >> i) & 1;
            if(!curr.containsKey(currBit)){
                curr.put(currBit, new Node());
            }
            curr = curr.get(currBit);
        }
    }
    
    public int getMax(int bit){
        Node curr = root;
        int maxNum = 0;
        for(int i = 31; i >= 0; i--){
            int currBit = (bit >> i) & 1;
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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(queries[i][0]);
            temp.add(queries[i][1]);
            temp.add(i);
            offlineQueries.add(temp);
        }
        
        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>> () {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(1).compareTo(b.get(1));
            }
        });
        
        int index = 0;
        
        Trie trie = new Trie();
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        
        for(int i = 0; i < queries.length; i++){
            while(index < nums.length && nums[index] <= offlineQueries.get(i).get(1)){
                trie.insert(nums[index]);
                index++;
            }
            int queryIndex = offlineQueries.get(i).get(2);
            if(index != 0){
                ans[queryIndex] = trie.getMax(offlineQueries.get(i).get(0));
            }else{
                ans[queryIndex] = -1;
            }
        }
        return ans;
    }
}
