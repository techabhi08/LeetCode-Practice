class Tuple {
    int distance;
    int row;
    int col;
    
    Tuple(int distance, int row, int col){
        this.row = row;
        this.distance = distance;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = (int)(1e9);
            }
        }
        
        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        while(pq.size() != 0){
            Tuple curr = pq.peek();
            pq.poll();
            int diff = curr.distance;
            int row = curr.row;
            int col = curr.col;
            
            if(row == n - 1 && col == m - 1){
                return diff;
            }
            
            for(int i = 0; i < 4; i++){
                int nRow = row + dr[i];
                int nCol = col + dc[i];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                    int effort = Math.max(Math.abs(heights[row][col] - heights[nRow][nCol]), diff);
                    if(effort < dist[nRow][nCol]){
                        dist[nRow][nCol] = effort;
                        pq.add(new Tuple(effort, nRow, nCol));
                    }
                }
            }
        }
        return 0;
    }
}
