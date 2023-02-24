class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    queue.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        
        int distance = -1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            distance++;
            
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                
                for(int[] dir : dirs){
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];
                    
                    if(nRow < n && nRow >= 0 && nCol >= 0 && nCol < m && !vis[nRow][nCol]){
                        queue.add(new int[]{nRow, nCol});
                        vis[nRow][nCol] = true;
                    }
                }
            }
        }
        return distance == 0 ? -1 : distance;
    }
}
