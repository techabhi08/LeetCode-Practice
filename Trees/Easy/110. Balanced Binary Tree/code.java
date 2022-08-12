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
    public boolean isBalanced(TreeNode root) {
        return findHeight(root) != -1;
        
        //2nd Solution
//         if(root == null){
//             return true;
//         }
        
//         int leftHeight = findHeight(root.left);
//         int rightHeight = findHeight(root.right);
        
//         if(Math.abs(leftHeight - rightHeight) > 1){
//             return false;
//         }
        
//         boolean left = isBalanced(root.left);
//         boolean right = isBalanced(root.right);
        
//         if(!left || !right){
//             return false;
//         }
//         return true;
    }
    
    public int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        
        if(leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
//     public int findHeight(TreeNode node){
//         int count = 0;
//         if(node == null){
//             return count;
//         }
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(node);
        
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
}
