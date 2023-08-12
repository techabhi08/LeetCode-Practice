class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return findPath(n - 1, m - 1, obstacleGrid, dp);
    }
    
    public int findPath(int row, int col, int[][] grid, int[][] dp){
        if(row < 0 || col < 0 || grid[row][col] == 1){
            return 0;
        }
        
        if(row == 0 && col == 0){
            return 1;
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int left = findPath(row, col - 1, grid, dp);
        int up = findPath(row - 1, col, grid, dp);
        
        return dp[row][col] = left + up;
    }
}