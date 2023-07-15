class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        int mins = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!queue.isEmpty() && fresh != 0){
            int size = queue.size();
            mins++;
            
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
            
                for(int[] dir : dirs){
                    int nRow = curr[0] + dir[0];
                    int nCol = curr[1] + dir[1];
                    
                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1){
                        grid[nRow][nCol] = 2;
                        queue.add(new int[]{nRow, nCol});
                        fresh--;
                    }
                }
            }
        }
        
        return fresh == 0 ? mins : -1;
    }
}