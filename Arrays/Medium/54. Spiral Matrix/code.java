class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int beginRow = 0;
        int endRow = matrix.length - 1;
        int beginColumn = 0;
        int columnEnd = matrix[0].length - 1;
        
        if(matrix.length == 0){
            return result;
        }
        
        while(beginRow <= endRow && beginColumn <= columnEnd){
            //Going right
            for(int i = beginColumn; i <= columnEnd; i++){
                result.add(matrix[beginRow][i]);
            }
            beginRow++;
            
            for(int i = beginRow; i <= endRow; i++){
                result.add(matrix[i][columnEnd]);
            }
            columnEnd--;
            
            if(beginRow <= endRow){
                for(int i = columnEnd; i >= beginColumn; i--){
                    result.add(matrix[endRow][i]);
                }
            }
            endRow--;
            
            if(beginColumn <= columnEnd){
                for(int i = endRow; i >= beginRow; i--){
                    result.add(matrix[i][beginColumn]);
                }
            }
            beginColumn++;
            
        }
        return result;
    }
}
