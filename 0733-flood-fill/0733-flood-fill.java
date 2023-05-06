class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int src = image[sr][sc];
        if(src == color){
            return image;
        }
        dfs(image, src, sr, sc, color);
        return image;
    }
    
    public void dfs(int[][] image, int src, int sr, int sc, int color){
        if(sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == src){
            image[sr][sc] = color;
            dfs(image, src, sr + 1, sc, color);
            dfs(image, src, sr - 1, sc, color);
            dfs(image, src, sr, sc + 1, color);
            dfs(image, src, sr, sc - 1, color);
        }
    }
}