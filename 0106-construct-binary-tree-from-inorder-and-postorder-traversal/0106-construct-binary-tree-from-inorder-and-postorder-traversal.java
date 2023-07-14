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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        TreeNode root = findTree(0, inorder.length - 1, inorder, 0, postorder.length - 1, postorder, map);
        return root;
    }
    
    public TreeNode findTree(int iS, int iE, int[] inorder, int pS, int pE, int[] postorder, Map<Integer, Integer> map){
        if(iS > iE || pS > pE){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[pE]);
        int inorderRoot = map.get(postorder[pE]);
        int numsLeft = inorderRoot - iS;
        
        root.left = findTree(iS, iS + numsLeft, inorder, pS, pS + numsLeft - 1, postorder, map);
        root.right = findTree(inorderRoot + 1, iE, inorder, pS + numsLeft, pE - 1, postorder, map);
        return root;
    }
}