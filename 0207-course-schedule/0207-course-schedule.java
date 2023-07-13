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
        int[] pathVis = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            if(isCycle(i, vis, pathVis, adj)){
                return false;
            }
        }
        return true;
    }
    
    public boolean isCycle(int node, int[] vis, int[] pathVis, List<List<Integer>> adj){
        vis[node] = 1;
        pathVis[node] = 1;
        
        for(int item : adj.get(node)){
            if(vis[item] == 0){
                if(isCycle(item, vis, pathVis, adj)){
                    return true;
                }
            }else if(pathVis[item] == 1){
                return true;
            }
        }
        
        pathVis[node] = 0;
        return false;
    }
}