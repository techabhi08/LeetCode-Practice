class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        if(grid[0][0] == 0){
            dp[0][0] = 1;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0 && grid[i][j] == 0){
                    dp[i][j] = 1;
                }
                else if(grid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    int left = 0, up = 0;
                    if(j - 1 >= 0) left = dp[i][j - 1];
                    if(i - 1 >= 0) up = dp[i - 1][j];
                    
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}