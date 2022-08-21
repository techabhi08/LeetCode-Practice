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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
           return false;
        }
        if(root.left == null && root.right == null && root.val == targetSum){
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
    
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         int sum = 0;
//         Stack<TreeNode> stack = new Stack<>();
//         Stack<Integer> value = new Stack<>();
//         if(root == null){
//             return false;
//         }
        
//         stack.push(root);
//         value.push(root.val);
//         while(!stack.isEmpty()){
//             TreeNode temp = stack.pop();
//             int tempVal = value.pop();
//             if(temp.left == null && temp.right == null && tempVal == targetSum){
//                 return true;
//             }else{
//                 if(temp.left != null){
//                     stack.push(temp.left);
//                     value.push(tempVal + temp.left.val);
//                 }
//                 if(temp.right != null){
//                     stack.push(temp.right);
//                     value.push(tempVal + temp.right.val);
//                 }
//             }
//         }
//         return false;
//     }
}
