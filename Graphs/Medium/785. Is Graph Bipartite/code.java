class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        
        for(int i = 0; i < n; i++){
            color[i] = -1;
        }
        for(int i = 0; i < n; i++){
            if(color[i] == -1 && !isColorPossible(i, graph, color)){
                return false;
            }
        }
        return true;
    }
    
    public boolean isColorPossible(int node, int[][] graph, int[] color){
        if(color[node] == -1){
            color[node] = 0;
        }
        
        for(int item : graph[node]){
            if(color[item] == -1){
                color[item] = 1 - color[node];
                
                if(!isColorPossible(item, graph, color)){
                    return false;
                }
            }else if(color[item] == color[node]){
                return false;
            }
            
        }
        return true;
    }
}
