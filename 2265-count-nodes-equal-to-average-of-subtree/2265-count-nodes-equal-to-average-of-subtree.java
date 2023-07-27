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

class Node{
    int sum;
    int size;
    
    Node(int sum, int size){
        this.sum = sum;
        this.size = size;
    }
}
class Solution {
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        findCount(root);
        return count;
    }
    
    public Node findCount(TreeNode root){
        if(root == null){
            return new Node(0, 0);
        }
        
        Node left = findCount(root.left);
        Node right = findCount(root.right);
        
        int sum = left.sum + right.sum + root.val;
        int size = left.size + right.size + 1;
        
        if(sum / size == root.val){
            count++;
        }
        
        return new Node(sum, size);
    }
}