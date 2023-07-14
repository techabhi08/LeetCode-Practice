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
    int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return constructTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode constructTree(int[] preorder, int min, int max){
        if(index == preorder.length || preorder[index] <= min || preorder[index] >= max){
            return null;
        }
        
        int val = preorder[index];
        index++;
        TreeNode root = new TreeNode(val);
        root.left = constructTree(preorder, min, val);
        root.right = constructTree(preorder, val, max);
        return root;
    }
}