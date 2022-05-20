class Solution {
    public void setZeroes(int[][] matrix) {
        int[] rNo = new int[matrix.length];
        int[] cNo = new int[matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    rNo[i] = 1;
                    cNo[j] = 1;
                }
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(rNo[i] == 1 || cNo[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
