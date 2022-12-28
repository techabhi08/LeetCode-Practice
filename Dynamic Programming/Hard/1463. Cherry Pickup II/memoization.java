class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        return findPath(0, 0, m - 1, grid, dp);
    }
    
    public int findPath(int i, int j1, int j2, int[][] grid, int[][][] dp){
        int n = grid.length;
        int m = grid[0].length;
        
        //Out of bound conditions
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m){
            return (int)-1e8;
        }
        
        //Base condition
        if(i == n - 1){
            if(j1 == j2){
                return grid[i][j1];
            }else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        
        if(dp[i][j1][j2] != 0){
            return dp[i][j1][j2];
        }
        
        //This is the maximum sum generated form the 9 cases;
        int max = 0;
        
        //Exploring all the paths
        for(int dj1 = -1; dj1 <= 1; dj1++){
            for(int dj2 = -1; dj2 <= 1; dj2++){
                //If both are on same cell we will add the cell only once
                if(j1 == j2){
                    max = Math.max(max, grid[i][j1] + findPath(i + 1, j1 + dj1, j2 + dj2, grid, dp));
                }else{
                    max = Math.max(max, grid[i][j1] + grid[i][j2] + findPath(i + 1, j1 + dj1, j2 + dj2, grid, dp));
                }
            }
        }
        
        return dp[i][j1][j2] = max;
        
    }
}
