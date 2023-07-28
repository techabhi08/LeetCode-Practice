class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    if(!vis[i][j]){
                        int ans = dfs(i, j, vis, grid);
                        max = Math.max(max, ans);
                    }
                }
            }
        }
        return max;
    }
    
    public int dfs(int i, int j, boolean[][] vis, int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] || grid[i][j] == 0){
            return 0;
        }
        vis[i][j] = true;
        int left = dfs(i, j - 1, vis, grid);
        int right = dfs(i, j + 1, vis, grid);
        int up = dfs(i - 1, j, vis, grid);
        int down = dfs(i + 1, j, vis, grid);
        
        return 1 + left + right + up + down;
    }
}