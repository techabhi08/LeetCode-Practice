class Solution {
    public int minPathSum(int[][] grid) {
        //Memoization solution
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return findSum(m - 1, n - 1, grid, dp);
    }
    
    public int findSum(int row, int col, int[][] grid, int[][] dp){
        if(row == 0 && col == 0){
            return grid[row][col];
        }
        if(row < 0 || col < 0){
            return 1000000;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int left = grid[row][col] + findSum(row, col - 1, grid, dp);
        int up = grid[row][col] + findSum(row - 1, col, grid, dp);
        
        return dp[row][col] = Math.min(left, up);
    }
}
