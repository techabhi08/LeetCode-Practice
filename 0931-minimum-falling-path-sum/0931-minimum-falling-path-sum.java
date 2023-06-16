class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        int[] prev = new int[n];
        for(int i = 0; i < n; i++){
            prev[i] = matrix[0][i];
        }
        
        for(int i = 1; i < n; i++){
            int[] curr = new int[n];
            for(int j = 0; j < n; j++){
                int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                int up = matrix[i][j] + prev[j];
                if(j - 1 >= 0)left = matrix[i][j] + prev[j - 1];
                if(j + 1 < n) right = matrix[i][j] + prev[j + 1];

                curr[j] = Math.min(left, Math.min(right, up));
            }
            prev = (int[])curr.clone();
        }
        
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, prev[i]);
        }
        return ans;
    }
}