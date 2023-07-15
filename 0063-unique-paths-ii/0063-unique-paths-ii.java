class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findMax(n - 1, m - 1, obstacleGrid, dp);
    }
    
    public int findMax(int i, int j, int[][] grid, int[][] dp){
        if(i < 0 || j < 0 || grid[i][j] == 1){
            return 0;
        }
        if(i == 0 && j == 0){
            return 1;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int left = findMax(i, j - 1, grid, dp);
        int up = findMax(i - 1, j, grid, dp);
        
        return dp[i][j] = left + up;
    }
}