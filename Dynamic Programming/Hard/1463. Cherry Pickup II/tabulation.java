class Solution {
    public int cherryPickup(int[][] grid) {
        //Tabulation solution - using 3D - DP
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        
        //Writing the values of base case in dp array
        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){
                if(j1 == j2){
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                }else{
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }
        
        for(int i = n - 2; i >= 0; i--){
            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){
                    //Storing the max value
                    int max = (int)-1e8;
                    //Exploring all the paths
                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){
                            //If both are on same cell we will add the cell only once
                            int value = 0;
                            if(j1 == j2){
                                value = grid[i][j1];
                            }else{
                                value = grid[i][j1] + grid[i][j2];
                            }
                            
                            if(j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m){
                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            }else{
                                value += (int)-1e8;
                            }
                            max = Math.max(max, value);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][m - 1];
    }
}
