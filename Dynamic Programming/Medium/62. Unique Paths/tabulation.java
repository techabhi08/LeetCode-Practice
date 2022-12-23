class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return findPaths(m - 1, n - 1, dp);
    }
    
    public int findPaths(int row, int col, int[][] dp){
        dp[0][0] = 1;
        
        for(int i = 0; i <= row; i++){
            for(int j = 0; j <= col; j++){
                if(i == 0 && j == 0){
                    dp[0][0] = 1;
                }else{
                    int up = 0;
                    int left = 0;
                    if(i > 0){
                        up = dp[i - 1][j];
                    }
                    if(j > 0){
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[row][col];
    }
}
