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
//     public int maxDepth(TreeNode root) {
//         int count = 0;
//         if(root == null){
//             return count;
//         }
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
        
//         while(!queue.isEmpty()){
//             count++;
//             int size = queue.size();
//             for(int i = 0; i < size; i++){
//                 TreeNode temp = queue.poll();
//                 if(temp.left != null){
//                     queue.add(temp.left);
//                 }
//                 if(temp.right != null){
//                     queue.add(temp.right);
//                 }
//             }
//         }
//         return count;
//     }
  public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
