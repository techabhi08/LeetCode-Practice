//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class DisjointSet{
    int[] parent;
    int[] size;
    
    DisjointSet(int n){
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
    public int MaxConnection(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                
                for(int[] dir : dirs){
                    int nRow = i + dir[0];
                    int nCol = j + dir[1];
                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1){
                        int num = i * n + j;
                        int adjNum = nRow * n + nCol;
                        ds.union(num, adjNum);
                    }
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    continue;
                }
                Set<Integer> set = new HashSet<>();
                
                for(int[] dir : dirs){
                    int nRow = dir[0] + i;
                    int nCol = dir[1] + j;
                    
                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1){
                        int num = nRow * n + nCol;
                        int parent = ds.findParent(num);
                        set.add(parent);
                    }
                }
                
                int size = 0;
                for(int item : set){
                    size += ds.size[item];
                }
                max = Math.max(size + 1, max);
            }
        }
        
        for(int i = 0; i < n * n; i++){
            max = Math.max(max, ds.size[ds.findParent(i)]);
        }
        
        return max;
    }
}