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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root == null){
            return list;
        }
        
        boolean traversedRight = true;
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> inner = new ArrayList<>();
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                if(traversedRight == true){
                    inner.add(temp.val);
                }else{
                   inner.add(0, temp.val);
                }
            }
            traversedRight = !traversedRight;
            list.add(inner);
        }
        return list;
    }
}
