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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return ans;
        }
        
        findView(root, 0);
        return ans;
    }
    
    public void findView(TreeNode root, int level){
        if(root == null){
            return;
        }
        
        if(ans.size() == level){
            ans.add(root.val);
        }
        
        findView(root.right, level + 1);
        findView(root.left, level + 1);
    }
}