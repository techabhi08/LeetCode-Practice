class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            if(!vis[i][0] && grid[i][0] == 1){
                dfs(i, 0, vis, grid);
            }
            if(!vis[i][m - 1] && grid[i][m - 1] == 1){
                dfs(i, m - 1, vis, grid);
            }
        }
        
        for(int j = 0; j < m; j++){
            if(!vis[0][j] && grid[0][j] == 1){
                dfs(0, j, vis, grid);
            }
            if(!vis[n - 1][j] && grid[n - 1][j] == 1){
                dfs(n - 1, j, vis, grid);
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int i, int j, boolean[][] vis, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        
        if(i >= 0 && i < n && j >= 0 && j < m && !vis[i][j] && grid[i][j] == 1){
            vis[i][j] = true;
            grid[i][j] = 0;
            dfs(i + 1, j, vis, grid);
            dfs(i - 1, j , vis, grid);
            dfs(i, j + 1, vis, grid);
            dfs(i, j - 1, vis, grid);
        }
    }
}