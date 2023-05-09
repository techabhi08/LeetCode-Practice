class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        
        int rowS = 0;
        int colS = 0;
        int rowE = matrix.length - 1;
        int colE = matrix[0].length - 1;
        
        while(rowS <= rowE && colS <= colE){
            for(int i = colS; i <= colE; i++){
                ans.add(matrix[rowS][i]);
            }
            rowS++;
            
            for(int i = rowS; i <= rowE; i++){
                ans.add(matrix[i][colE]);
            }
            colE--;
            
            if(rowS <= rowE){
                for(int i = colE; i >= colS; i--){
                    ans.add(matrix[rowE][i]);
                }
            }
            rowE--;
            
            if(colS <= colE){
                for(int i = rowE; i >= rowS; i--){
                    ans.add(matrix[i][colS]);
                }
            }
            colS++;
        }
        return ans;
    }
}