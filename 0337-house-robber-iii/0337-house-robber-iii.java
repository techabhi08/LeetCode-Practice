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
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        if(map.containsKey(root)){
            return map.get(root);
        }
        
        int ans = 0;
        if(root.left != null){
            ans += rob(root.left.left) + rob(root.left.right);
        }
        
        if(root.right != null){
            ans += rob(root.right.left) + rob(root.right.right);
        }
        
        int res = Math.max(ans + root.val, rob(root.left) + rob(root.right));
        map.put(root, res);
        return res;
    }
}