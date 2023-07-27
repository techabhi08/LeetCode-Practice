class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ans = 0;
        long min = Integer.MAX_VALUE;
        int count = 0;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] < 0){
                    count++;
                }
                
                ans += Math.abs(matrix[i][j]);
                min = Math.min(min, Math.abs(matrix[i][j]));
            }
        }
        
        if(count % 2 == 0){
            return ans;
        }
        return ans - 2 * min;
    }
}