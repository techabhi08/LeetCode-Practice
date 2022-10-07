class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1;
        }
        int ans = 0;
        
        int row = grid.length;
        int col = grid[0].length;
        
        if(grid[0][0] == 1 || grid[row - 1][col - 1] == 1){
            return -1;
        }
        
        boolean[][] visited = new boolean[row][col];
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            ans++;
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                
                if(curr[0] == row - 1 && curr[1] == col - 1){
                    return ans;
                }
                
                for(int[] dir : dirs){
                    int nRow = curr[0] + dir[0];
                    int nCol = curr[1] + dir[1];
                    
                    if(nRow >= 0 && nRow < row && nCol >= 0 && nCol < col && !visited[nRow][nCol] && grid[nRow][nCol] == 0){
                        visited[nRow][nCol] = true;
                        queue.add(new int[]{nRow, nCol});
                    }
                }
            }
        }
        return -1;
    }
}
