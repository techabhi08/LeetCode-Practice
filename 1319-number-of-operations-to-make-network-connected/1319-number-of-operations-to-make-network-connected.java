class DisjointSet{
    int[] size;
    int[] parent;
    
    DisjointSet(int n){
        size = new int[n];
        parent = new int[n];
        
        for(int i = 0; i < n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }
    
    public int findParent(int node){
        if(parent[node] == node){
            return node;
        }
        
        int ulp = findParent(parent[node]);
        parent[node] = ulp;
        return ulp;
    }
    
    public void union(int u, int v){
        u = findParent(u);
        v = findParent(v);
        
        if(u == v){
            return;
        }
        if(size[u] < size[v]){
            parent[u] = v;
            size[v] = size[u] + size[v];
        }else{
            parent[v] = u;
            size[u] = size[u] + size[v];
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extra = 0;
        
        for(int i = 0; i < connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            
            if(ds.findParent(u) == ds.findParent(v)){
                extra++;
            }else{
                ds.union(u, v);
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(ds.parent[i] == i){
                count++;
            }
        }
        
        int ans = count - 1;
        if(extra >= ans){
            return ans;
        }else{
            return -1;
        }
    }
}