class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        int[] prev = new int[n];
        
        for(int i = 0; i < matrix.length; i++){
            prev[i] = matrix[0][i];
        }
        
        for(int row = 1; row < n; row++){
            int[] curr = new int[n];
            for(int col = 0; col < n; col++){
                int right = 1000000, left = 1000000;
                int down = matrix[row][col] + prev[col];
                if(col - 1 >= 0)left = matrix[row][col] + prev[col - 1];
                if(col + 1 < n)right = matrix[row][col] + prev[col + 1];
                curr[col] = Math.min(down, Math.min(left, right));
            }
            prev = curr;
        }
        
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, prev[i]);
        }
        return ans;   
    }
}
