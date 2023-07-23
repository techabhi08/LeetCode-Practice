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
    public List<TreeNode> allPossibleFBT(int n) {
        //Final list which stores all the root nodes
        List<TreeNode> ans = new ArrayList<>();
        
        //If n is even it is not possible to construct "Complete Binary Tree"
        if(n % 2 == 0){
            return new ArrayList<>();
        }
        
        if(n == 1){
            ans.add(new TreeNode(0));
            return ans;
        }
        
        for(int i = 1; i < n; i += 2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            
            for(TreeNode node : left){
                for(TreeNode rightNode : right){
                    ans.add(new TreeNode(0, node, rightNode));
                }
            }
        }
        
        return ans;
    }
}