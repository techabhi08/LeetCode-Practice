class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int org = image[sr][sc];
        
        if(org == color){
            return image;
        }
        image[sr][sc] = color;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
                
            for(int[] dir : dirs){
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                    
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && image[nRow][nCol] == org){
                    image[nRow][nCol] = color;
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }
        return image;
    }
}