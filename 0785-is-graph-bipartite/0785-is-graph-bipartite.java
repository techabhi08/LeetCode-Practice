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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 0;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int item : graph[curr]){
                if(color[item] == -1){
                    queue.add(item);
                    color[item] = 1 - color[curr];
                }else if(color[item] == color[curr]){
                    return false;
                }
            }
        }
        return true;
    }
}