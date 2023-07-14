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
class BSTIterator {
    List<Integer> inorder;
    int index = 0;
    public BSTIterator(TreeNode root) {
        inorder = new ArrayList<>();
        findInorder(root, inorder);
    }
    
    public int next() {
        int val = inorder.get(index);
        index++;
        return val;
    }
    
    public boolean hasNext() {
        return index != inorder.size();
    }
    
    public void findInorder(TreeNode root, List<Integer> inorder){
        if(root == null){
            return;
        }
        
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                inorder.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == curr){
                    prev.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }else{
                    prev.right = curr;
                    curr = curr.left;
                }
            }
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */