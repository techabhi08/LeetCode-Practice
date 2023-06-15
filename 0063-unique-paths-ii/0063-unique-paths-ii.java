class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return findPaths(n - 1, m - 1, obstacleGrid, dp);
    }
    
    public int findPaths(int i, int j, int[][] obstacleGrid, int[][] dp){
        if(i == 0 && j == 0 && obstacleGrid[i][j] != 1){
            return 1;
        }
        if(i < 0 || j < 0 || obstacleGrid[i][j] == 1){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int left = findPaths(i, j - 1, obstacleGrid, dp);
        int up = findPaths(i - 1, j, obstacleGrid, dp);
        
        return dp[i][j] = left + up;
    }
}