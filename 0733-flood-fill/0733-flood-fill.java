class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int src = image[sr][sc];
        if(src == color){
            return image;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            
            for(int[] dir : dirs){
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                
                if(nRow >= 0 && nRow < image.length && nCol >= 0 && nCol < image[0].length && image[nRow][nCol] == src){
                    image[nRow][nCol] = color;
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }
        return image;
    }
}