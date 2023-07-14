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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        TreeNode root = findTree(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder, map);
        return root;
    }
    
    public TreeNode findTree(int pS, int pE, int[] preorder, int iS, int iE, int[] inorder, Map<Integer, Integer> map){
        if(pS > pE || iS > iE){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[pS]);
        int inorderRoot = map.get(preorder[pS]);
        int leftNums = inorderRoot - iS;
        
        root.left = findTree(pS + 1, pS + leftNums, preorder, iS, iS + leftNums, inorder, map);
        root.right = findTree(pS + leftNums + 1, pE, preorder, inorderRoot + 1, iE, inorder, map);
        return root;
    }
}