//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        
        Set<List<String>> set = new HashSet<>();
        boolean[][] vis = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    List<String> list = new ArrayList<>();
                    dfs(i, j, i, j, vis, grid, list);
                    set.add(list);
                }
            }
        }
        
        return set.size();
    }
    
    public void dfs(int i, int j, int sr, int sc, boolean[][] vis, int[][] grid, List<String> list){
        int n = grid.length;
        int m = grid[0].length;
        vis[i][j] = true;
        list.add(toString(i - sr, j - sc));
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for(int[] dir : dirs){
            int nRow = i + dir[0];
            int nCol = j + dir[1];
            
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !vis[nRow][nCol] && grid[nRow][nCol] == 1){
                dfs(nRow, nCol, sr, sc, vis, grid, list);
            }
        }
    }
    
    private String toString(int r, int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
}
