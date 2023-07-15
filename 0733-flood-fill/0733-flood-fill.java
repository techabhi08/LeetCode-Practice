class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        
        int org = image[sr][sc];
        if(org == color){
            return image;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            for(int dir[] : dirs){
                int nRow = curr[0] + dir[0];
                int nCol = curr[1] + dir[1];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && image[nRow][nCol] == org){
                    image[nRow][nCol] = color;
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }
        
        return image;
    }
}