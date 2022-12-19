class DisjointSet {
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
            size[ulp_v] = size[ulp_v] + size[ulp_u];
        }else{
            parent[ulp_v] = ulp_u;
            size[ulp_u] = size[ulp_v] + size[ulp_u];
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        // Step - 1: Connecting all the 1's that form an island by surrounding 1's.
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for(int[] dir : dirs){
                    int nRow = i + dir[0];
                    int nCol = j + dir[1];
                    
                    if(nRow >= 0 && nRow < n && nCol>=0 && nCol<n && grid[nRow][nCol] == 1){
                        int nodeNo = i * n + j;
                        int adjNo = nRow * n + nCol;
                        ds.unionBySize(nodeNo, adjNo);
                    }
                }
            }
        }
        
        // Step - 2: Converting 1 of the 0's to 1 and checking the max area of island
        int max = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1){
                    continue;
                }
                int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                Set<Integer> set = new HashSet<>();
                
                for(int[] dir : dirs){
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];
                    
                    if(nRow >= 0 && nRow < n && nCol>=0 && nCol<n && grid[nRow][nCol] == 1){
                        set.add(ds.findParent(nRow * n + nCol));
                    }
                }
                int sizeTotal = 0;
                for(int parent : set){
                    sizeTotal += ds.size[parent];
                }
                max = Math.max(max, sizeTotal + 1);
            }
        }
        for(int i = 0; i < n * n; i++){
            max = Math.max(max, ds.size[ds.findParent(i)]);
        }
        return max;
    }
}
