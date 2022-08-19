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
    class Pair{
        int num;
        TreeNode node;
        Pair(TreeNode node, int num){
            this.num = num;
            this.node = node;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int n = queue.peek().num;
            int start = 0;
            int last = 0;
            for(int i = 0; i < size; i++){
                int curr_id = queue.peek().num - n;
                TreeNode node = queue.peek().node;
                queue.poll();
                
                if(i == 0){
                    start = curr_id;
                }else if(i == size - 1){
                    last = curr_id;
                }
                if(node.left != null){
                    queue.offer(new Pair(node.left, curr_id * 2 + 1));
                }
                if(node.right != null){
                    queue.offer(new Pair(node.right, curr_id * 2 + 2));
                }
            }
            ans = Math.max(ans, last - start + 1);
        }
        return ans;
    }
}
