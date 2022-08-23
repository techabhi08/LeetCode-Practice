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
        if(root == null){
            return 0;
        }
        int left = findHeightLeft(root);
        int right = findHeightRight(root);
        
        if(left == right){
            return ((2 << left) - 1);
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public int findHeightLeft(TreeNode root){
        int count = 0;
        while(root.left != null){
            root = root.left;
            count++;
        }
        return count;
    }
    public int findHeightRight(TreeNode root){
        int count = 0;
        while(root.right != null){
            root = root.right;
            count++;
        }
        return count;
    }
}
