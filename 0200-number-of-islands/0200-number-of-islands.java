class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(i, j, grid);
                }
            }
        }
        return count;
    }
    
    public void bfs(int i, int j, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            
            
            for(int[] dir : dirs){
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == '1'){
                    grid[nRow][nCol] = '0';
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }
    }
}