class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        int dist = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!queue.isEmpty()){
            int size = queue.size();
            dist++;
            
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                
                for(int[] dir : dirs){
                    int nRow = curr[0] + dir[0];
                    int nCol = curr[1] + dir[1];
                    
                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !vis[nRow][nCol]){
                        queue.add(new int[]{nRow, nCol});
                        vis[nRow][nCol] = true;
                        mat[nRow][nCol] = dist;
                    }
                }
            }
        }
        return mat;
    }
}