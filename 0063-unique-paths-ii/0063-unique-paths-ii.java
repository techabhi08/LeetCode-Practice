class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        if(obstacleGrid[0][0] == 0){
            dp[0][0] = 1;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0 && obstacleGrid[i][j] == 0){
                    dp[i][j] = 1;
                }else if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    int left = 0, up = 0;
                    if(j - 1 >= 0){
                        left = dp[i][j - 1];
                    }
                    if(i - 1 >= 0){
                        up = dp[i - 1][j];
                    }

                    dp[i][j] = left + up;
                }
            }
        }
        
        return dp[n - 1][m - 1];
    }
    
}