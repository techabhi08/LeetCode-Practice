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
    public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         if(root == null){
//             return list;
//         }
        
//         Stack<TreeNode> stack = new Stack<>();
        
//         while(true){
//             if(root != null){
//                 stack.push(root);
//                 root = root.left;
//             }else{
//                 if(stack.isEmpty()){
//                     break;
//                 }
//                 root = stack.peek();
//                 list.add(root.val);
//                 stack.pop();
//                 root = root.right;
//             }
//         }
//         return list;
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }
    
    public void inorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
