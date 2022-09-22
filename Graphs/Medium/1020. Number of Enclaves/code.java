class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[] dRows = {-1, 1, 0, 0};
        int[] dCols = {0, 0, -1, 1};
        
        Queue<int[]> queue = new LinkedList<>(); 
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1){
                    if(grid[i][j] == 1){
                        queue.add(new int[]{i, j});
                        visited[i][j] = 1;
                    }
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int first = temp[0];
            int second = temp[1];
            
            for(int i = 0; i < 4; i++){
                int nRow = first + dRows[i];
                int nCol = second + dCols[i];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                    visited[nRow][nCol] = 1;
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
