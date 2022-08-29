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
        List<Integer> inorder = new ArrayList<>();
        
        TreeNode curr = root;
        int count = 0;
        while(curr != null){
            if(curr.left == null){
                inorder.add(curr.val);
                count++;
                if(count == k){
                    return curr.val;
                }
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null;
                    inorder.add(curr.val);
                    count++;
                    if(count == k){
                        return curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}

// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode curr = root;
//         int count = 0;
        
//         while(true){
//             if(curr != null){
//                 stack.push(curr);
//                 curr = curr.left;
//             }else{
//                 if(stack.isEmpty()){
//                     break;
//                 }else{
//                     curr = stack.pop();
//                     count++;
//                     if(count == k){
//                         return curr.val;
//                     }
//                     curr = curr.right;
//                 }
//             }
//         }
//         return -1;
//     }
// }
