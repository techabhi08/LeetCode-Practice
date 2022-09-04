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

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    boolean reverse = true;
    
    public BSTIterator(TreeNode root, boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public int next(){
        TreeNode temp = stack.pop();
        if(reverse == false){
            pushAll(temp.right);
        }else {
            pushAll(temp.left);
        }
        return temp.val;
    }
    
    public void pushAll(TreeNode root){
        while(root != null){
            stack.push(root);
            if(!reverse){
                root = root.left;
            }else{
                root = root.right;
            }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        
        BSTIterator inorder = new BSTIterator(root, false);
        BSTIterator revInorder = new BSTIterator(root, true);
        
        int start = inorder.next();
        int end = revInorder.next();
        while(start < end){
            if((start + end) == k){
                return true;
            }else if((start + end) < k){
                start = inorder.next();
            }else{
                end = revInorder.next();
            }
        }
        return false;
    }
}
