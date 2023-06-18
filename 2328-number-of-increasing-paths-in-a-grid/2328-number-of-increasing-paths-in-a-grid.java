class Solution {
    int mod = (int)1e9 + 7;
    public int countPaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                count += findPaths(i, j, -1, grid, dp);
                count %= mod;
            }
        }
        return count;
    }
    
    public int findPaths(int i, int j, int prev, int[][] grid, int[][] dp){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] <= prev){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int left = findPaths(i, j - 1, grid[i][j], grid, dp);
        int right = findPaths(i, j + 1, grid[i][j], grid, dp);
        int up = findPaths(i - 1, j, grid[i][j], grid, dp);
        int down = findPaths(i + 1, j, grid[i][j], grid, dp);
        
        return dp[i][j] = (1 + left + right + up + down) % mod;
    }
}