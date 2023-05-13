class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int[] vis = new int[numCourses];
        int[] dfsVis = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            if(vis[i] == 0){
                if(dfs(i, -1, vis, dfsVis, adj)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean dfs(int node, int parent, int[] vis, int[] dfsVis, List<List<Integer>> adj){
        vis[node] = 1;
        dfsVis[node] = 1;
        
        for(int item : adj.get(node)){
            if(vis[item] == 0){
                if(dfs(item, node, vis, dfsVis, adj)){
                    return true;
                }
            }else if(dfsVis[item] == 1){
                return true;
            }
        }
        dfsVis[node] = 0;
        return false;
    }
}