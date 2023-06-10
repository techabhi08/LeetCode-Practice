class DisjointSet{
    int[] parent;
    int[] size;
    
    DisjointSet(int n){
        parent = new int[n + 1];
        size = new int[n + 1];
        
        for(int i = 0; i <= n; i++){
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
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int i = 0; i < stones.length; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < stones.length; i++){
            int u = stones[i][0];
            int v = stones[i][1] + maxRow + 1;
            ds.union(u, v);
            
            set.add(u);
            set.add(v);
        }
        
        int count = 0;
        for(int item : set){
            if(ds.findParent(item) == item){
                count++;
            }
        }
        
        return stones.length - count;
    }
}