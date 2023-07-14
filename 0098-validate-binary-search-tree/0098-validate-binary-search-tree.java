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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return findIsBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean findIsBST(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        
        if(root.val <= min || root.val >= max){
            return false;
        }
        
        boolean left = findIsBST(root.left, min, root.val);
        boolean right = findIsBST(root.right, root.val, max);
        
        return left && right;
    }
}