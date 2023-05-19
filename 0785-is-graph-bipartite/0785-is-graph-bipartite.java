class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(!dfs(i, color, graph, 0)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean dfs(int node, int[] color, int[][] graph, int c){
        if(color[node] != -1){
            return color[node] == c;
        }
        
        color[node] = c;
        for(int item : graph[node]){
            if(!dfs(item, color, graph, 1 - c)){
                return false;
            }
        }
        
        return true;
    }
}