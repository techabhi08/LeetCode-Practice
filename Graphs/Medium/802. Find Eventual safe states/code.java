class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] check = new int[n];
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(i, graph, check, vis, pathVis, ans);
            }
        }
        
        for(int i = 0; i < n; i++){
            if(check[i] == 1){
                ans.add(i);
            }
        }
        return ans;
    }
    
    public boolean dfs(int node, int[][] graph, int[] check, int[] vis, int[] dfsVis, List<Integer> ans){
        vis[node] = 1;
        dfsVis[node] = 1;
        check[node] = 0;
        
        for(int item : graph[node]){
            if(vis[item] == 0){
                if(dfs(item, graph, check, vis, dfsVis, ans)){
                    return true;
                }
            }else if(dfsVis[item] == 1){
                return true;
            }
        }
        check[node] = 1;
        dfsVis[node] = 0;
        return false;
    }
}
