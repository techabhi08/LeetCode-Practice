class Solution {
    public int cherryPickup(int[][] grid) {
        //Space optimising solution - using 2D - DP
        int n = grid.length;
        int m = grid[0].length;
        int[][] prev = new int[m][m];
        int[][] curr = new int[m][m];
        
        //Writing the values of base case in dp array
        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){
                if(j1 == j2){
                    prev[j1][j2] = grid[n - 1][j1];
                }else{
                    prev[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }
        
        for(int i = n - 2; i >= 0; i--){
            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){
                    //Storing the max value
                    int max = (int)-1e8;
                    //Exploring all the paths
                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){
                            //If both are on same cell we will add the cell only once
                            int value = 0;
                            if(j1 == j2){
                                value = grid[i][j1];
                            }else{
                                value = grid[i][j1] + grid[i][j2];
                            }
                            
                            if(j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m){
                                value += prev[j1 + dj1][j2 + dj2];
                            }else{
                                value += (int)-1e8;
                            }
                            max = Math.max(max, value);
                        }
                    }
                    curr[j1][j2] = max;
                }
            }
            for (int a = 0; a < m; a++) {
                prev[a] = (int[])(curr[a].clone());
            }
        }
        return prev[0][m - 1];
    }
}
