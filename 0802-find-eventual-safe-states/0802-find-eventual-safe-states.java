class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] count = new int[n];
        
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(i, vis, pathVis, count, graph);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(count[i] == 1){
                ans.add(i);
            }
        }
        return ans;
    }
    
    public boolean dfs(int node, int[] vis, int[] pathVis, int[] count, int[][] graph){
        vis[node] = 1;
        pathVis[node] = 1;
        
        for(int item : graph[node]){
            if(vis[item] == 0){
                if(dfs(item, vis, pathVis, count, graph)){
                    return true;
                }
            }else if(pathVis[item] == 1){
                return true;
            }
        }
        
        pathVis[node] = 0;
        count[node] = 1;
        return false;
    }
}