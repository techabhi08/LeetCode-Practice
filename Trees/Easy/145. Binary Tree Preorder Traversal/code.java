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
    public List<Integer> postorderTraversal(TreeNode root) {
        //Using recursion
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
        //Using 2 Stacks
//         List<Integer> list = new ArrayList<>();
        
//         if(root == null){
//             return list;
//         }
        
//         Stack<TreeNode> stack1 = new Stack<>();
//         Stack<TreeNode> stack2 = new Stack<>();
//         stack1.push(root);
//         while(!stack1.isEmpty()){
//             root = stack1.peek();
//             stack1.pop();
//             stack2.push(root);
//             if(root.left != null){
//                 stack1.push(root.left);
//             }
//             if(root.right != null) {
//                 stack1.push(root.right);
//             }
//         }
        
//         while(!stack2.isEmpty()){
//             list.add(stack2.peek().val);
//             stack2.pop();
//         }
//         return list;
    }
    
    public void postorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }
}
