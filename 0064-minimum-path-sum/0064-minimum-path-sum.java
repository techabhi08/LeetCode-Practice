class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }else{
                    int left = 1000000, up = 1000000;
                    if(j - 1 >= 0) left = grid[i][j] + dp[i][j - 1];
                    if(i - 1 >= 0) up = grid[i][j] + dp[i - 1][j];
                    
                    dp[i][j] = Math.min(left, up);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}