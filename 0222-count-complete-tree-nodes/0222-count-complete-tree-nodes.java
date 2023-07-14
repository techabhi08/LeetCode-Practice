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
    public int countNodes(TreeNode root) {
        int ans = 0;
        if(root == null){
            return 0;
        }
        
        int left = findHeight(root, true);
        int right = findHeight(root, false);
        
        if(left == right){
            return (2 << right) - 1;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public int findHeight(TreeNode root, boolean left){
        if(root == null){
            return 0;
        }
        
        int count = 0;
        if(left){
            while(root.left != null){
                count++;
                root = root.left;
            }
        }else{
            while(root.right != null){
                count++;
                root = root.right;
            }
        }
        return count;
    }
}