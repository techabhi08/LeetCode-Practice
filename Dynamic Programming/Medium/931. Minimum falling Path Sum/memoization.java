class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, findFallingPath(n - 1, i, matrix, dp));
        }
        return ans;
    }
    
    public int findFallingPath(int row, int col, int[][] matrix, int[][] dp){
        if(col < 0 || col >= matrix.length){
            return (int)1e8;
        }
        
        if(row == 0){
            return matrix[row][col];
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int down = matrix[row][col] + findFallingPath(row - 1, col, matrix, dp);
        int left = matrix[row][col] + findFallingPath(row - 1, col - 1, matrix, dp);
        int right = matrix[row][col] + findFallingPath(row - 1, col + 1, matrix, dp);
        return dp[row][col] = Math.min(down, Math.min(left, right));
    }
}
