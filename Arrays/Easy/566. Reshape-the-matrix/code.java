class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        
        int[][] result = new int[r][c];
    
        if(r * c != row * col){
            return mat;
        }
        
        int result_row = 0;
        int result_col = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                result[result_row][result_col] = mat[i][j];
                result_col++;
                if(result_col == c){
                    result_col = 0;
                    result_row++;
                }
            }
        }
        
        return result;
    }
}
