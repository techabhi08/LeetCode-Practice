/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                sb.append("n ");
                continue;
            }
            sb.append(curr.val + " ");
            queue.add(curr.left);
            queue.add(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }
        
        String[] str = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        queue.add(root);
        
        for(int i = 1; i < str.length; i++){
            TreeNode curr = queue.poll();
            if(!str[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(str[i]));
                curr.left = left;
                queue.add(left);
            }
            if(!str[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(str[i]));
                curr.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));