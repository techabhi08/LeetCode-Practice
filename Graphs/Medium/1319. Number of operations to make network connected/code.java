class DisjointSet{
    int[] parent;
    int[] size;
    
    public DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findParent(int node){
        if(parent[node] == node){
            return node;
        }
        int ulp = findParent(parent[node]);
        parent[node] = ulp;
        return parent[node];
    }
    
    public void unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(ulp_u == ulp_v){
            return;
        }
        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = ulp_v;
            size[ulp_v] = size[ulp_u] + size[ulp_v];
        }else{
            parent[ulp_v] = ulp_u;
            size[ulp_u] = size[ulp_u] + size[ulp_v];
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        DisjointSet ds = new DisjointSet(n);
        int rounds = 0;
        int len = connections.length;
        
        for(int i = 0; i < len; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findParent(u) == ds.findParent(v)){
                rounds++;
            }else{
                ds.unionBySize(u, v);
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(ds.parent[i] == i){
                count++;
            }
        }
        
        int ans = count - 1;
        if(rounds >= ans){
            return ans;
        }else{
            return -1;
        }
    }
}
