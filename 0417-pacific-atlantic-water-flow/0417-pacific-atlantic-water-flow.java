class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        
        boolean[][] atlantic = new boolean[n][m];
        boolean[][] pacific = new boolean[n][m];
        
        for(int i = 0; i < m; i++){
            dfs(heights, 0, i, heights[0][i], pacific);
            dfs(heights, n - 1, i, heights[n - 1][i], atlantic);
        }
        
        for(int i = 0; i < n; i++){
            dfs(heights, i, 0, heights[i][0], pacific);
            dfs(heights, i, m - 1, heights[i][m - 1], atlantic);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(atlantic[i][j] && pacific[i][j]){
                    List<Integer> inner = new ArrayList<>();
                    inner.add(i);
                    inner.add(j);
                    ans.add(inner);
                }
            }
        }
        return ans;
    }
    
    public void dfs(int[][] heights, int row, int col, int prevHeight, boolean[][] arr){
        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || heights[row][col] < prevHeight || arr[row][col]){
            return;
        }
        arr[row][col] = true;
        dfs(heights, row + 1, col, heights[row][col], arr);
        dfs(heights, row - 1, col, heights[row][col], arr);
        dfs(heights, row, col + 1, heights[row][col], arr);
        dfs(heights, row, col - 1, heights[row][col], arr);
    }
}