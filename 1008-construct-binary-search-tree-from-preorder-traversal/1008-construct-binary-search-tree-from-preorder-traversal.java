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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        
        for(int i = 1; i < preorder.length; i++){
            buildTree(preorder[i], root);
        }
        return root;
    }
    
    public void buildTree(int val, TreeNode root){
        TreeNode curr = root;
        
        while(curr != null){
            if(curr.val > val){
                if(curr.left != null){
                    curr = curr.left;
                }else{
                    curr.left = new TreeNode(val);
                    return;
                }
            }else{
                if(curr.right != null){
                    curr = curr.right;
                }else{
                    curr.right = new TreeNode(val);
                    return;
                }
            }
        }
    }
}