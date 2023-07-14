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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        
        TreeNode curr = root;
        findInorder(curr, ans);
        
        return ans.get(k - 1);
    }
    
    public void findInorder(TreeNode curr, List<Integer> ans){
        if(curr == null){
            return;
        }
        
        findInorder(curr.left, ans);
        ans.add(curr.val);
        findInorder(curr.right, ans);
    }
}