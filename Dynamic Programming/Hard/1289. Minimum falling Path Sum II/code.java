class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        for(int i = 0; i < n; i++){zz
        }
        return ans;
    }
    
    public int findPathSum(int row, int col, int[][] grid, int[][] dp){
        if(col < 0 || col >= grid.length){
            return Integer.MAX_VALUE - 100000;
        }
        if(row == grid.length - 1){
            return grid[row][col];
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < grid.length; i++){
            if(i != col){
                min = Math.min(min, grid[row][col] + findPathSum(row + 1, i, grid, dp));
            }
        }
        return dp[row][col] = min;
    }
}
