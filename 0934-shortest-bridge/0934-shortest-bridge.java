class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean foundOne = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    queue.add(new int[]{i, j});
                    dfs(i, j, grid, queue);
                    foundOne = true;
                    break;
                }
            }
            if(foundOne){
                break;
            }
        }
        
        int level = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                
                for(int[] dir : dirs){
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];
                    
                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && grid[nRow][nCol] != 2){
                        if(grid[nRow][nCol] == 1){
                            return level;
                        }else{
                            grid[nRow][nCol] = 2;
                            queue.add(new int[]{nRow, nCol});
                        }
                    }
                }
            }
            level++;
        }
        return level;
    }
    
    public void dfs(int row, int col, int[][] grid, Queue<int[]> queue){
        int n = grid.length;
        if(row >= 0 && row < n && col >= 0 && col < n && grid[row][col] != 2 && grid[row][col] != 0){
            grid[row][col] = 2;
            queue.add(new int[]{row, col});
            
            dfs(row + 1, col, grid, queue);
            dfs(row - 1, col, grid, queue);
            dfs(row, col + 1, grid, queue);
            dfs(row, col - 1, grid, queue);
        }
    }
}