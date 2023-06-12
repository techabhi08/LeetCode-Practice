class Solution {
    int timer = 1;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<>();
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(List<Integer> item : connections){
            int u = item.get(0);
            int v = item.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        dfs(0, -1, vis, tin, low, adj, bridges);
        return bridges;
    }
    
    public void dfs(int node, int parent, int[] vis, int[] tin, int[] low, List<List<Integer>> adj, List<List<Integer>> bridges){
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        
        for(int item : adj.get(node)){
            if(parent == item){
                continue;
            }
            if(vis[item] == 0){
                dfs(item, node, vis, tin, low, adj, bridges);
                low[node] = Math.min(low[node], low[item]);
                if(low[item] > tin[node]){
                    bridges.add(Arrays.asList(item, node));
                }
            }else{
                low[node] = Math.min(low[node], low[item]);
            }
        }
    }
}