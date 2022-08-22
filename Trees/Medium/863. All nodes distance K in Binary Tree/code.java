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
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track);
        
        int currDist = 0;
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.put(target, true);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            if(currDist == k){
                break;
            }
            currDist++;
            
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null && visited.get(curr.left) == null){
                    queue.add(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    queue.add(curr.right);
                    visited.put(curr.right, true);
                }
                if(parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null){
                    queue.add(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            ans.add(curr.val);
        }
        return ans;
    }
    
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        parent_track.put(root, null);
        
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.left != null){
                queue.add(curr.left);
                parent_track.put(curr.left, curr);
            }
            if(curr.right != null){
                queue.add(curr.right);
                parent_track.put(curr.right, curr);
            }
        }
    }
}
