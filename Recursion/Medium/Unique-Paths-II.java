class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] res = new int[row][col];
        // System.out.println(solve(res,0,0,obstacleGrid));
        return solve(obstacleGrid, 0, 0, res);
    }
    
    static int solve(int[][] obstacleGrid, int row, int col, int[][] res){

        if(row > res.length-1 || col > res[0].length-1){
            return 0;
        }

        if(obstacleGrid[row][col] == 1){
            return 0;
        }

        if(res[row][col] >= 1){
            return res[row][col];
        }

        if(row == res.length-1 && col == res[0].length-1){
            res[row][col] = res[row][col]+1;
            return res[row][col];
        }

        res[row][col] = solve(obstacleGrid, row+1, col, res) +
            solve(obstacleGrid, row, col+1, res);

        return res[row][col];
    }
}
