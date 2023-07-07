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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(isEqual(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public boolean isEqual(TreeNode root, TreeNode temp){
        if(root == null || temp == null){
            return root == temp;
        }
        if(root.val != temp.val){
            return false;
        }
        boolean left = isEqual(root.left, temp.left);
        boolean right = isEqual(root.right, temp.right);
        
        return left && right;
    }
}