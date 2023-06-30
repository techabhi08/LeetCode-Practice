class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0;
        int right = row * col;
        int latestDay = 0;
        
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(isPath(row, col, mid, cells)){
                left = mid;
                latestDay = mid;
            }else{
                right = mid;
            }
        }
        return latestDay;
    }
    
    public boolean isPath(int n, int m, int mid, int[][] cells){
        int[][] grid = new int[n + 1][m + 1];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < mid; i++){
            grid[cells[i][0]][cells[i][1]] = 1;
        }
        
        for(int i = 1; i <= m; i++){
            if(grid[1][i] == 0){
                queue.add(new int[]{1, i});
                grid[1][i] = 1;
            }
        }
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            
            
            for(int[] dir : dirs){
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                
                if(nRow > 0 && nRow <= n && nCol > 0 && nCol <= m && grid[nRow][nCol] == 0){
                    grid[nRow][nCol] = 1;
                    if(nRow == n){
                        return true;
                    }
                    
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }
        return false;
    }
}