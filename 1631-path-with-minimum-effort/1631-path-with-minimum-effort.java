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
        
        int[][] ans = new int[n][m];
        for(int[] row : ans){
            Arrays.fill(row, (int)1e8);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(0, 0, 0));
        ans[0][0] = 0;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int dist = curr.dist;
            
            if(row == n - 1 && col == m - 1){
                return dist;
            }
            
            for(int[] dir : dirs){
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                    int effort = Math.max(dist, Math.abs(heights[row][col] - heights[nRow][nCol]));
                    if(effort < ans[nRow][nCol]){
                        ans[nRow][nCol] = effort;
                        pq.add(new Pair(nRow, nCol, effort));
                    }
                }
            }
        }
        return 0;
    }
}