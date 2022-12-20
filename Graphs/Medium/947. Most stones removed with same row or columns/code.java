class DisjointSet {
    int[] parent;
    int[] size;
    
    public DisjointSet(int n){
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
            size[ulp_v] = size[ulp_v] + size[ulp_u];
        }else{
            parent[ulp_v] = ulp_u;
            size[ulp_u] = size[ulp_v] + size[ulp_u];
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
        Map<Integer, Integer> stoneNodes = new HashMap<>();
        
        for(int i = 0; i < stones.length; i++){
            int row = stones[i][0];
            int col = stones[i][1] + maxRow + 1;
            ds.unionBySize(row, col);
            stoneNodes.put(row, 1);
            stoneNodes.put(col, 1);
        }
        
        int count = 0;
        for(Map.Entry<Integer, Integer> item : stoneNodes.entrySet()){
            if(ds.findParent(item.getKey()) == item.getKey()){
                count++;
            }
        }
        
        return stones.length - count;
    }
}
