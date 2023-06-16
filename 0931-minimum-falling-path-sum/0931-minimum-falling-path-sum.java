class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                int up = matrix[i][j] + dp[i - 1][j];
                if(j - 1 >= 0)left = matrix[i][j] + dp[i - 1][j - 1];
                if(j + 1 < n) right = matrix[i][j] + dp[i - 1][j + 1];

                dp[i][j] = Math.min(left, Math.min(right, up));
            }
        }
        
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}