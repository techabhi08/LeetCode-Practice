class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        int[] vis = new int[n];
        int[] dfsVis = new int[n];
        int[] count = new int[n];
        
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(i, -1, graph, vis, dfsVis, count);
            }
        }
        
        for(int i = 0; i < n; i++){
            if(count[i] == 1){
                ans.add(i);
            }
        }
        ans.sort(null);
        return ans;
    }
    
    public boolean dfs(int node, int parent, int[][] graph, int[] vis, int[] dfsVis, int[] count){
        vis[node] = 1;
        dfsVis[node] = 1;
        
        for(int item : graph[node]){
            if(vis[item] == 0){
                if(dfs(item, node, graph, vis, dfsVis, count)){
                    return true;
                }
            }else if(dfsVis[item] == 1){
                return true;
            }
        }
        
        dfsVis[node] = 0;
        count[node] = 1;
        return false;
    }
}