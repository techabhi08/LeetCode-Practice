class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] next = new int[m][m];
        int[][] curr = new int[m][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(i == j){
                    next[i][j] = grid[n - 1][i];
                }else{
                    next[i][j] = grid[n - 1][i] + grid[n - 1][j];
                }
            }
        }
        
        int max = 0;
        for(int i = n - 2; i >= 0; i--){
            for(int j1 = m - 1; j1 >= 0; j1--){
                for(int j2 = m - 1; j2 >= 0; j2--){
                    int maxi = (int)-1e8;
                    for(int a = -1; a <= 1; a++){
                        for(int b = -1; b <= 1; b++){
                            int value = 0;
                            if(j1 == j2){
                                value = grid[i][j1];
                            }else{
                                value = grid[i][j1] + grid[i][j2];
                            }
                            
                            if(j1 + a >= 0 && j1 + a < m && j2 + b >= 0 && j2 + b < m){
                                value += next[j1 + a][j2 + b];
                            }else{
                                value += (int)-1e8;
                            }
                            maxi = Math.max(maxi, value);
                        }
                    }
                    curr[j1][j2] = maxi;
                }
            }
            
            for(int k = 0; k < m; k++){
                next[k] = (int[])curr[k].clone();
            }
        }
        
        return next[0][m - 1];
    }
}