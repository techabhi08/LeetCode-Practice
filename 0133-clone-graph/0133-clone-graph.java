/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        
        Node copy = new Node(node.val);
        Node[] vis = new Node[101];
        dfs(node, copy, vis);
        
        return copy;
    }
    
    public void dfs(Node node, Node copy, Node[] vis){
        vis[copy.val] = copy;
        
        for(Node item : node.neighbors){
            if(vis[item.val] == null){
                Node newNode = new Node(item.val);
                copy.neighbors.add(newNode);
                dfs(item, newNode, vis);
            }else{
                copy.neighbors.add(vis[item.val]);
            }
        }
    }
}