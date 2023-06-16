class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        
        int[][] dp = new int[n][m];
        for(int i = 0; i < m; i++){
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }
        
        for(int row = n - 2; row >= 0; row--){
            for(int col = 0; col <= row; col++){
                int down = triangle.get(row).get(col) + dp[row + 1][col];
                int right = triangle.get(row).get(col) + dp[row + 1][col + 1];

                dp[row][col] = Math.min(down, right);
            }
        }
        return dp[0][0];
    }
}