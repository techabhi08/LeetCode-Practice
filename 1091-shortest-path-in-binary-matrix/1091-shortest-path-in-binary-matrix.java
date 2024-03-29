class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if(n == 0 || grid == null || grid[0][0] == 1 || grid[n - 1][n - 1] == 1){
            return -1;
        }
        
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        vis[0][0] = true;
        
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            ans++;
            
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                
                if(row == n - 1 && col == n - 1){
                    return ans;
                }
                
                for(int j = -1; j <= 1; j++){
                    for(int k = -1; k <= 1; k++){
                        int nRow = row + j;
                        int nCol = col + k;
                        if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && !vis[nRow][nCol] && grid[nRow][nCol] == 0){
                            queue.add(new int[]{nRow, nCol});
                            vis[nRow][nCol] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}