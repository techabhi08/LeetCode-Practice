class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return findPaths(m - 1, n - 1, dp);
    }
    
    public int findPaths(int row, int col, int[][] dp){
        if(row == 0 && col == 0){
            return 1;
        }
        
        if(row < 0 || col < 0){
            return 0;
        }
        
        if(dp[row][col] != 0){
            return dp[row][col];
        }
        
        int left = findPaths(row, col - 1, dp);
        int up = findPaths(row - 1, col, dp);
        
        return dp[row][col] = left + up;
    }
}
