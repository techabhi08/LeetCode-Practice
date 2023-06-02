class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(!isBipartite(i, color, graph)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isBipartite(int node, int[] color, int[][] graph){
        if(color[node] == -1){
            color[node] = 0;
        }
        for(int item : graph[node]){
            if(color[item] == -1){
                color[item] = 1 - color[node];
                if(!isBipartite(item, color, graph)){
                    return false;
                }
            }else if(color[item] == color[node]){
                return false;
            }
        }
        
        return true;
    }
}