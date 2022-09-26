class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    count += dfs(i, j, grid);
                }
            }
        }
        return count;
    }
    
    public int dfs(int i, int j, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int ans = 4;
        
        //checking for block below
        if(i + 1 < n && grid[i + 1][j] == 1){
            ans--;
        }
        //checking for block above
        if(i - 1 >= 0 && grid[i - 1][j] == 1){
            ans--;
        }
        //checking for block to right
        if(j + 1 < m && grid[i][j + 1] == 1){
            ans--;
        }
        //checking for block to left
        if(j - 1 >= 0 && grid[i][j - 1] == 1){
            ans--;
        }
        return ans;
    }
}
