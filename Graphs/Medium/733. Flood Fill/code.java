class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inColor = image[sr][sc];
        
        if(inColor != color){
            dfs(image, sr, sc, color, inColor);
        }
        return image;
    }
    public void dfs(int[][] image, int i, int j, int newColor, int color){
        if(i >= 0 && i < image.length && j >= 0 && j < image[0].length && image[i][j] == color){
            image[i][j] = newColor;
            dfs(image, i + 1, j, newColor, color);
            dfs(image, i - 1, j, newColor, color);
            dfs(image, i, j + 1, newColor, color);
            dfs(image, i, j - 1, newColor, color);
        }
    }
}
