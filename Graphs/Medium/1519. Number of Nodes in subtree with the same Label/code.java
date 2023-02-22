class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] ans = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        dfs(0, -1, adj, labels, ans);
        return ans;
    }
    
    public int[] dfs(int node, int parent, List<List<Integer>> adj, String labels, int[] ans){
        
        int[] count = new int[26];
        for(int item : adj.get(node)){
            if(item != parent){
                
                int[] res = dfs(item, node, adj, labels, ans);
                
                for(int i = 0; i < res.length; i++){
                    count[i] += res[i];
                }
            }
        }
        
        ans[node] = ++count[labels.charAt(node) - 'a'];
        return count;
    }
}
