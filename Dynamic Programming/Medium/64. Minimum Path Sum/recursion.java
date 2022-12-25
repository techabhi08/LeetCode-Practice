class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return findSum(m - 1, n - 1, grid);
    }
    
    public int findSum(int row, int col, int[][] grid){
        if(row == 0 && col == 0){
            return grid[row][col];
        }
        if(row < 0 || col < 0){
            return 1000000;
        }
        
        int left = grid[row][col] + findSum(row, col - 1, grid);
        int up = grid[row][col] + findSum(row - 1, col, grid);
        
        return Math.min(left, up);
    }
}
