class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return findPath(m - 1, n - 1, obstacleGrid, dp);
    }
    
    public int findPath(int row, int col, int[][] grid, int[][] dp){
        if(row >= 0 && col >= 0 && grid[row][col] == 1){
            return 0;
        }
        
        if(row == 0 && col == 0){
            return 1;
        }
        
        if(row < 0 || col < 0){
            return 0;
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int left = findPath(row, col - 1, grid, dp);
        int right = findPath(row - 1, col, grid, dp);
        
        return dp[row][col] = left + right;
    }
}
