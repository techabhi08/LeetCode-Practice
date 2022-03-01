class Solution {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        return countPaths(res, 0, 0);
    }
    
    public int countPaths(int[][] res, int row, int col){
        if(row > res.length-1 || col > res[0].length-1){
            return 0;
        }

        if(res[row][col] >= 1){
            return res[row][col];
        }

        if(row == res.length-1 && col == res[0].length-1){
            res[row][col] = res[row][col]+1;
            return res[row][col];
        }

        res[row][col] = countPaths(res,row+1,col) + countPaths(res,row,col+1);

        return res[row][col];
    }
}
