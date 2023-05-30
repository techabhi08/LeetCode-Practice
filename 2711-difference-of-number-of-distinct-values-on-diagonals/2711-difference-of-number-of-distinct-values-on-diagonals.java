class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] ans = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                Set<Integer> topDiagonal = new HashSet<>();
                for(int r = i - 1, c = j - 1; r >= 0 && c >= 0; r--, c--){
                    topDiagonal.add(grid[r][c]);
                }
                
                Set<Integer> bottomDiagonal = new HashSet<>();
                for(int r = i + 1, c = j + 1; r < n && c < m; r++, c++){
                    bottomDiagonal.add(grid[r][c]);
                }
                
                ans[i][j] = Math.abs(topDiagonal.size() - bottomDiagonal.size());
            }
        }
        return ans;
    }
}