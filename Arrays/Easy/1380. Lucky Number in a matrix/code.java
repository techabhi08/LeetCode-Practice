class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> number = new ArrayList<>();
        int k = 0;
        
        for(int i = 0; i < matrix.length; i++){
            
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    k = j;
                }
            }
            
            
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < matrix.length; j++){
            
                if(matrix[j][k] > max){
                    max = matrix[j][k];
                }
            }
            
            if(min == max){
                number.add(min);
            }
        }
        return number;
    }
}
