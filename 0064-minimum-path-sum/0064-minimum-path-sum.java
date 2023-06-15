class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] prev = new int[m];
        
        for(int i = 0; i < n; i++){
            int[] curr = new int[m];
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    curr[j] = grid[i][j];
                }else{
                    int left = 1000000, up = 1000000;
                    if(j - 1 >= 0) left = grid[i][j] + curr[j - 1];
                    if(i - 1 >= 0) up = grid[i][j] + prev[j];

                    curr[j] = Math.min(left, up);
                }
            }
            prev = curr;
        }
        return prev[m - 1];
    }
    
}