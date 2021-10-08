class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int len = mat.length - 1;
        for(int i = 0; i < mat.length; i++){
            sum += mat[i][i];
        }
        for(int j = 0; j < mat.length; j++){
            sum += mat[j][len];
            len--;
        }
        if(mat.length % 2 != 0){
            sum = sum - mat[mat.length/2][mat.length/2];
        }
        return sum;
    }
}
