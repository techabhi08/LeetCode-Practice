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
            dp[0][i] = matrix[0][i];
        }
        
        for(int row = 1; row < n; row++){
            for(int col = 0; col < n; col++){
                int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                int down = matrix[row][col] + dp[row - 1][col];
                if(col - 1 >= 0) left = matrix[row][col] + dp[row - 1][col - 1];
                if(col + 1 < n) right = matrix[row][col] + dp[row - 1][col + 1];
                dp[row][col] = Math.min(down, Math.min(left, right));
            }
        }
        
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}
