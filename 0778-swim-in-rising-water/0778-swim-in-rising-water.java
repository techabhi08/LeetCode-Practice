class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] vis = new int[n][n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, grid[0][0]});
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            for(int[] dir : dirs){
                int nRow = curr[0] + dir[0];
                int nCol = curr[1] + dir[1];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0){
                    vis[nRow][nCol] = 1;
                    int time = Math.max(curr[2], grid[nRow][nCol]);
                    if(nRow == n - 1 && nCol == n - 1){
                        return time;
                    }
                    pq.add(new int[]{nRow, nCol, time});
                }
            }
        }
        
        return 0;
    }
}