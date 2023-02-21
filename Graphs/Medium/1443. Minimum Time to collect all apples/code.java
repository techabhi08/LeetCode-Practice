class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        return dfs(0, visited, adj, hasApple);
    }
    
    public int dfs(int node, boolean[] visited, List<List<Integer>> adj, List<Boolean> hasApple){
        visited[node] = true;
        
        int totalTime = 0;
        
        for(int child : adj.get(node)){
            if(visited[child] == false){            
                totalTime += dfs(child, visited, adj, hasApple);
            }
        }
        
        if(node != 0 && (hasApple.get(node) || totalTime > 0)){
            totalTime += 2;
        }
        return totalTime;
    }
}
