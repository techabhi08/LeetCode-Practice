class Solution {
    private int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
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
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, adj, vis, tin, low, bridges);
        return bridges;
    }
    
    public void dfs(int node, int parent, List<List<Integer>> adj, int[] vis, int[] tin, int[] low, List<List<Integer>> bridges){
        vis[node] = 1;
        tin[node] = timer;
        low[node] = timer;
        timer++;
        
        for(int item : adj.get(node)){
            if(item == parent){
                continue;
            }
            if(vis[item] == 0){
                dfs(item, node, adj, vis, tin, low, bridges);
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
