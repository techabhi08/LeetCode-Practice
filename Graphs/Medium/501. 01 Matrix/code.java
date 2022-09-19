class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int n = mat.length;
        int m = mat[0].length;
        int[][] visited = new int[n][m];
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }
        
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int step = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                for(int[] d : dir){
                    int nRow = row + d[0];
                    int nCol = col + d[1];
                    if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && visited[nRow][nCol]==0){
                        visited[nRow][nCol] = 1;
                        queue.add(new int[]{nRow, nCol});
                        mat[nRow][nCol] = step;
                    }
                }
            }
            step++;
        }
        return mat;
    }
}
