class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    if(dfs(i, j, grid)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    public boolean dfs(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return false;
        }
        if(grid[i][j] == 1 || grid[i][j] == -1){
            return true;
        }
        grid[i][j] = -1;
        boolean up = dfs(i - 1, j, grid);
        boolean down = dfs(i + 1, j, grid);
        boolean left = dfs(i, j - 1, grid);
        boolean right = dfs(i, j + 1, grid);
        
        return up && down && left && right;
    }
}