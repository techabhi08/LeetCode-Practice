class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for(int[][] row : dp){
            for(int[] item : row){
                Arrays.fill(item, -1);
            }
        }
        
        return findMax(0, 0, m - 1, grid, dp);
    }
    
    public int findMax(int i, int j1, int j2, int[][] grid, int[][][] dp){
        if(j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length){
            return (int)-1e8;
        }
        
        if(i == grid.length - 1){
            if(j1 == j2){
                return grid[i][j1];
            }
            return grid[i][j1] + grid[i][j2];
        }
        
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        
        int maxi = 0;
        for(int a = -1; a <= 1; a++){
            for(int b = -1; b <= 1; b++){
                if(j1 == j2){
                    maxi = Math.max(maxi, grid[i][j1] + findMax(i + 1, j1 + a, j2 + b, grid, dp));
                }else{
                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + findMax(i + 1, j1 + a, j2 + b, grid, dp));
                }
            }
        }
        
        return dp[i][j1][j2] = maxi;
    }
}