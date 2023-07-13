/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null){
            return root;
        }
        
        List<TreeNode> pPath = new ArrayList<>();
        findPath(root, p, pPath);
        List<TreeNode> qPath = new ArrayList<>();
        findPath(root, q, qPath);
        
        int i = 0, j = 0;
        TreeNode ans = null;
        while(i < pPath.size() && j < qPath.size()){
            if(pPath.get(i) == qPath.get(j)){
                ans = pPath.get(i);
            }
            i++;
            j++;
        }
        return ans;
    }
    
    public boolean findPath(TreeNode root, TreeNode p, List<TreeNode> list){
        if(root == null){
            return false;
        }
        
        list.add(root);
        
        if(root == p){
            return true;
        }
        
        if(findPath(root.left, p, list) || findPath(root.right, p, list)){
            return true;
        }
        
        list.remove(list.size() - 1);
        return false;
    }
}