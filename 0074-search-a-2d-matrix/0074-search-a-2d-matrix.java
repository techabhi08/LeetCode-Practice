class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix[0].length - 1;
        
        while(start < matrix.length && end >= 0){
            if(matrix[start][end] == target){
                return true;
            }else if(target > matrix[start][end]){
                start++;
            }else{
                end--;
            }
        }
        return false;
    }
}