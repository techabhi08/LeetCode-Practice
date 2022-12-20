class DisjointSet {
    private int[] parent;
    private int[] rank;
    
    public DisjointSet(int n){
        this.parent = new int[n];
        this.rank = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }
    
    public int findParent(int u){
        if(u == parent[u]){
            return u;
        }
        int ulp = findParent(parent[u]);
        parent[u] = ulp;
        return parent[u];
    }
    
    public void unionByRank(int u, int v){
        u = findParent(u);
        v = findParent(v);
        
        if(u == v){
            return;
        }
        if(rank[u] < rank[v]){
            parent[u] = v;
        }else if(rank[v] < rank[u]){
            parent[v] = u;
        }else{
            parent[v] = u;
            rank[u] += 1;
        }
    }
}
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSet ds = new DisjointSet(n);
        
        for(int[] edge : edges){
            ds.unionByRank(edge[0], edge[1]);
        }
        return ds.findParent(source) == ds.findParent(destination);
    }
}
