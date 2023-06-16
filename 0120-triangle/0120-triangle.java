class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        
        int[] next = new int[m];
        for(int i = 0; i < m; i++){
            next[i] = triangle.get(n - 1).get(i);
        }
        
        for(int row = n - 2; row >= 0; row--){
            int[] curr = new int[m];
            for(int col = 0; col <= row; col++){
                int down = triangle.get(row).get(col) + next[col];
                int right = triangle.get(row).get(col) + next[col + 1];

                curr[col] = Math.min(down, right);
            }
            next = curr;
        }
        return next[0];
    }
}