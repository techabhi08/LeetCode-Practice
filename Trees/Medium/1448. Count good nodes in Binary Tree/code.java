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
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int count = 1;
        
        count += countGreater(root.left, root.val);
        count += countGreater(root.right, root.val);
        
        return count;
    }
    
    public int countGreater(TreeNode root, int val){
        int count = 0;
        if(root == null){
            return 0;
        }
        
        if(root.val >= val){
            val = root.val;
            count++;
        }
        count += countGreater(root.left, val);
        count += countGreater(root.right, val);
        return count;
    }
}
