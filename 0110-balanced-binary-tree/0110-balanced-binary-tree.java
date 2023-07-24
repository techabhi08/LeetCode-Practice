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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        if(findHeight(root) == -1){
            return false;
        }
        
        return true;
    }
    
    public int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        
        if(left == -1 || right == -1){
            return -1;
        }
        
        if(Math.abs(left - right) > 1){
            return -1;
        }
        
        return 1 + Math.max(left, right);
    }
}