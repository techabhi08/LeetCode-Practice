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
class Pair{
    TreeNode node;
    int index;
    
    Pair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int maxi = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int start = 0, end = 0;
            int rowMin = queue.peek().index;
            
            for(int i = 0; i < size; i++){
                Pair curr = queue.poll();
                TreeNode node = curr.node;
                int index = curr.index - rowMin;
                
                if(i == 0){
                    start = index;
                }else if(i == size - 1){
                    end = index;
                }
                
                if(node.left != null){
                    queue.add(new Pair(node.left, index * 2));
                }
                if(node.right != null){
                    queue.add(new Pair(node.right, index * 2 + 1));
                }
            }
            
            maxi = Math.max(maxi, end - start + 1);
        }
        return maxi;
    }
}