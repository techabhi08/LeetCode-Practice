class Pair{
    int row;
    int col;
    int dist;
    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(0, 0, 0));
        
        int[][] dist = new int[n][m];
        for(int[] rows : dist){
            Arrays.fill(rows, (int)1e8);
        }
        dist[0][0] = 0;
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int d = curr.dist;
            
            if(row == n - 1 && col == m - 1){
                return d;
            }
            
            for(int[] dir : dirs){
                int nRow = dir[0] + row;
                int nCol = dir[1] + col;
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                    int effort = Math.max(d, Math.abs(heights[row][col] - heights[nRow][nCol]));
                    if(effort < dist[nRow][nCol]){
                        dist[nRow][nCol] = effort;
                        pq.add(new Pair(nRow, nCol, effort));
                    }
                }
            }
        }
        return 0;
    }
}