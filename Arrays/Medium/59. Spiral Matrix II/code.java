class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int num = 1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int i = colBegin; i <= colEnd; i++){
                result[rowBegin][i] = num;
                num++;
            }
            rowBegin++;
            
            for(int i = rowBegin; i <= rowEnd; i++){
                result[i][colEnd] = num;
                num++;
            }
            colEnd--;
            
            if(colBegin <= colEnd){
                for(int i = colEnd; i >= colBegin; i--){
                  result[rowEnd][i] = num;
                    num++;
                }
            }
            rowEnd--;
            
            if(rowBegin <= rowEnd){
                for(int i = rowEnd; i >= rowBegin; i--){
                  result[i][colBegin] = num;
                    num++;
                }
            }
            colBegin++;
        }
        return result;
    }
}
