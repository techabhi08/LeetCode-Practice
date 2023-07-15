class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findMin(0, 0, triangle, dp);
    }
    
    public int findMin(int row, int col, List<List<Integer>> triangle, int[][] dp){
        if(row == triangle.size() - 1){
            return triangle.get(row).get(col);
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int down = triangle.get(row).get(col) + findMin(row + 1, col, triangle, dp);
        int diag = triangle.get(row).get(col) + findMin(row + 1, col + 1, triangle, dp);
        
        return dp[row][col] = Math.min(down, diag);
    }
}