class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
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
    
    public void bfs(int row, int col, char[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            
            for(int[] dir : dirs){
                int nRow = dir[0] + r;
                int nCol = dir[1] + c;
                if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == '1'){
                    grid[nRow][nCol] = '0';
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }
    }
}