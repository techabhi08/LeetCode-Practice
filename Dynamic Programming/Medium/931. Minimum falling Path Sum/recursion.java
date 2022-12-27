class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, findFallingPath(n - 1, i, matrix));
        }
        return ans;
    }
    
    public int findFallingPath(int row, int col, int[][] matrix){
        if(col < 0 || col >= matrix.length){
            return (int)1e8;
        }
        
        if(row == 0){
            return matrix[row][col];
        }
        
        int down = matrix[row][col] + findFallingPath(row - 1, col, matrix);
        int left = matrix[row][col] + findFallingPath(row - 1, col - 1, matrix);
        int right = matrix[row][col] + findFallingPath(row - 1, col + 1, matrix);
        return Math.min(down, Math.min(left, right));
    }
}
