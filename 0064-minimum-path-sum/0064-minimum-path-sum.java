class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findPath(n - 1, m - 1, grid, dp);
    }
    
    public int findPath(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        
        if(i < 0 || j  < 0){
            return 1000000;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int left = grid[i][j] + findPath(i, j - 1, grid, dp);
        int up = grid[i][j] + findPath(i - 1, j, grid, dp);
        
        return dp[i][j] = Math.min(left, up);
    }
}