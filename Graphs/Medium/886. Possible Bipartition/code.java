class UnionByRank {
    int[] parent;
    int[] rank;
    
    public UnionByRank(int size){
        parent = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            parent[i] = i;
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
    
    public void union(int u, int v){
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
            parent[u] = v;
            rank[u] = rank[u]++;
        }
    }
}
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= n; i++){
            adj.put(i, new ArrayList<>());
        }
        
        for(int[] dislike : dislikes){
            adj.get(dislike[0]).add(dislike[1]);
            adj.get(dislike[1]).add(dislike[0]);
        }
        
        UnionByRank ds = new UnionByRank(n + 1);
        for(int i = 1; i <= n; i++){
            if(!adj.containsKey(i)){
                continue;
            }
            for(int node : adj.get(i)){
                if(ds.findParent(node) == ds.findParent(i)){
                    return false;
                }
                ds.union(adj.get(i).get(0), node);
            }
        }
        return true;
    }
}
