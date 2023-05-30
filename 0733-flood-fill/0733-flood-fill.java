class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org = image[sr][sc];
        
        if(org == color){
            return image;
        }
        dfs(image, sr, sc, color, org);
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int color, int src){
        if(sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == src){
            image[sr][sc] = color;
            dfs(image, sr + 1, sc, color, src);
            dfs(image, sr - 1, sc, color, src);
            dfs(image, sr, sc + 1, color, src);
            dfs(image, sr, sc - 1, color, src);
        }
    }
}