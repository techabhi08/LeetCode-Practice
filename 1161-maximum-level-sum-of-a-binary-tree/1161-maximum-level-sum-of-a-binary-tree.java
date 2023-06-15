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
    public int maxLevelSum(TreeNode root) {
        int ans = 0;
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            int sum = 0;
            
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                sum += curr.val;
                
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            
            if(sum > maxSum){
                maxSum = sum;
                ans = level;
            }
        }
        return ans;
    }
}