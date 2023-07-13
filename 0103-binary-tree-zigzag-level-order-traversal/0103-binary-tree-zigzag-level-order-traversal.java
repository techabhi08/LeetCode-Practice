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
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> inner = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
                if(isLeft){
                    inner.add(curr.val);
                }else{
                    inner.add(0, curr.val);
                }
            }
            isLeft = !isLeft;
            ans.add(inner);
        }
        return ans;
    }
}