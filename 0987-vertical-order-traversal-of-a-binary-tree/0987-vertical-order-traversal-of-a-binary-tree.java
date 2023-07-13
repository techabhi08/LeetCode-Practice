/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Tuple{
    TreeNode node;
    int col;
    int level;
    
    Tuple(TreeNode node, int col, int level){
        this.node = node;
        this.col = col;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));
        
        while(!queue.isEmpty()){
            Tuple curr = queue.poll();
            TreeNode node = curr.node;
            int col = curr.col;
            int level = curr.level;
            
            if(!map.containsKey(col)){
                map.put(col, new TreeMap<>());
            }
            
            if(!map.get(col).containsKey(level)){
                map.get(col).put(level, new PriorityQueue<>());
            }
            
            map.get(col).get(level).add(node.val);
            
            if(node.left != null){
                queue.add(new Tuple(node.left, col - 1, level + 1));
            }
            if(node.right != null){
                queue.add(new Tuple(node.right, col + 1, level + 1));
            }
        }
        
        for(TreeMap<Integer, PriorityQueue<Integer>> items : map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> item : items.values()){
                while(!item.isEmpty()){
                    ans.get(ans.size() - 1).add(item.poll());
                }
            }
        }
        return ans;
    }
}