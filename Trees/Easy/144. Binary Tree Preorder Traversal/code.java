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
    public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
        
//         if(root == null){
//             return list;
//         }
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);
        
//         while(!stack.isEmpty()){
//             TreeNode temp = stack.peek();
//             stack.pop();
//             list.add(temp.val);
            
//             if(temp.right != null){
//                 stack.push(temp.right);
//             }
//             if(temp.left != null){
//                 stack.push(temp.left);
//             }
//         }
//         return list;
      
      // Using Morris Traversal
//       List<Integer> preorder = new ArrayList<>();
//         TreeNode curr = root;
//         while(curr != null){
//             if(curr.left == null){
//                 preorder.add(curr.val);
//                 curr = curr.right;
//             }else{
//                 TreeNode prev = curr.left;
//                 while(prev.right != null && prev.right != curr){
//                     prev = prev.right;
//                 }
                
//                 if(prev.right == null){
//                     prev.right = curr;
//                     preorder.add(curr.val);
//                     curr = curr.left;
//                 }else{
//                     prev.right = null;
//                     curr = curr.right;
//                 }
//             }
//         }
//         return preorder;
        
        //Using recursion
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    
    public void preorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
