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
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        find(root, ans);
        return ans[0];
    }
    
    public int find(TreeNode root, int[] ans){
        if(root == null){
            return 0;
        }
        
        int left = Math.max(0, find(root.left, ans));
        int right = Math.max(0, find(root.right, ans));
        
        ans[0] = Math.max(ans[0], root.val + left + right);
        
        return root.val + Math.max(left, right);
    }
}