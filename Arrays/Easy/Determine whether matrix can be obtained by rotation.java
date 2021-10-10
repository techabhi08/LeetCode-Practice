class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = target.length;
        boolean r90 = true, r180 = true, r270 = true, r360 = true;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] != target[i][j]){
                    r360 = false;
                }
                if(mat[n - j - 1][i] != target[i][j]){
                    r90 = false;
                }
                if(mat[n - i - 1][n - j - 1] != target[i][j]){
                    r180 = false;
                }
                if(mat[j][n - i - 1] != target[i][j]){
                    r270 = false;
                }
            }
        }
        return r90 || r180 || r270 || r360;
    }
}
