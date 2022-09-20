class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges == 0){
            return 0;
        }
        if(queue.isEmpty()){
            return -1;
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;
        while(!queue.isEmpty() && freshOranges > 0){
            minutes++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                
                for(int[] dir : dirs){
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];
                    
                    if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == 1){
                        queue.add(new int[]{nRow, nCol});
                        grid[nRow][nCol] = 2;
                        freshOranges--;
                    }
                }
            }
        }
        return freshOranges == 0 ? minutes : -1;
    }
}
//
