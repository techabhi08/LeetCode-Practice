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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        findHeight(root, diameter);
        return diameter[0];
    }
    
    public int findHeight(TreeNode root, int[] diameter){
        if(root == null){
            return 0;
        }
        
        int left = findHeight(root.left, diameter);
        int right = findHeight(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        
        return Math.max(left, right) + 1;
    }
}
