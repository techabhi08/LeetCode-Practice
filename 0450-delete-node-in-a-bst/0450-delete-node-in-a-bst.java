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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        
        if(root.val == key){
            root = helper(root);
            return root;
        }
        
        TreeNode curr = root;
        while(curr != null){
            if(curr.val < key){
                if(curr.right != null && curr.right.val == key){
                    curr.right = helper(curr.right);
                    break;
                }else{
                    curr = curr.right;
                }
            }else{
                if(curr.left != null && curr.left.val == key){
                    curr.left = helper(curr.left);
                    break;
                }else{
                    curr = curr.left;
                }
            }
        }
        return root;
    }
    
    public TreeNode helper(TreeNode node){
        if(node.left != null && node.right != null){
            TreeNode rightChild = node.right;
            TreeNode lastRight = find(node.left);
            lastRight.right = rightChild;
            return node.left;
        }else if(node.left == null){
            return node.right;
        }else{
            return node.left;
        }
    }
    
    public TreeNode find(TreeNode node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }
}