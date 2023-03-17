class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zeroes = 0;
        int row = 0;
        int col = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    zeroes++;
                }else if(grid[i][j] == 1){
                    row = i;
                    col = j;
                }
            }
        }
        
        return findWays(row, col, zeroes, grid);
    }
    
    public int findWays(int row, int col, int zeroes, int[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || 
           grid[row][col] == -1){
            return 0;
        }
        
        if(grid[row][col] == 2){
            return zeroes == -1 ? 1 : 0;
        }
        
        grid[row][col] = -1;
        zeroes -= 1;
        int totalWays = findWays(row + 1, col, zeroes, grid) + 
            findWays(row - 1, col, zeroes, grid) + 
            findWays(row, col + 1, zeroes, grid) + 
            findWays(row, col - 1, zeroes, grid);
        
        grid[row][col] = 0;
        
        return totalWays;
    }
}
