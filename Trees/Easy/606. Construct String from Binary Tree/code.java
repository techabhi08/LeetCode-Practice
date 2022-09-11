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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            return "";
        }
        TreeNode temp = new TreeNode(0);
        Stack<TreeNode> queue = new Stack<>();
        queue.push(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.pop();
            if(node == temp){
                sb.append(')');
                continue;
                
            }
            sb.append('(').append(node.val);
            queue.push(temp);
            
            if(node.left == null && node.right != null){
                sb.append("()");
            }
            if(node.right != null){
                queue.push(node.right);
            }
            if(node.left != null){
                queue.push(node.left);
            }
        }
        return sb.substring(1, sb.length() - 1);
    }
}
