/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        findParent(root, parent);
        
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        vis.put(target, true);
        int dist = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            if(dist == k){
                break;
            }
            dist++;
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null && !vis.containsKey(curr.left)){
                    queue.add(curr.left);
                    vis.put(curr.left, true);
                }
                if(curr.right != null && !vis.containsKey(curr.right)){
                    queue.add(curr.right);
                    vis.put(curr.right, true);
                }
                if(parent.get(curr) != null && !vis.containsKey(parent.get(curr))){
                    queue.add(parent.get(curr));
                    vis.put(parent.get(curr), true);
                }
            }
        }
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            ans.add(curr.val);
        }
        return ans;
    }
    
    public void findParent(TreeNode root, Map<TreeNode, TreeNode> parent){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parent.put(root, null);
        
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.left != null){
                queue.add(curr.left);
                parent.put(curr.left, curr);
            }
            if(curr.right != null){
                queue.add(curr.right);
                parent.put(curr.right, curr);
            }
        }
    }
}