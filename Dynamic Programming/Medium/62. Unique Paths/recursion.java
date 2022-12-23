class Solution {
    public int uniquePaths(int m, int n) {
        return findPaths(m - 1, n - 1);
    }
    
    public int findPaths(int row, int col){
        if(row == 0 && col == 0){
            return 1;
        }
        
        if(row < 0 || col < 0){
            return 0;
        }
        
        int left = findPaths(row, col - 1);
        int up = findPaths(row - 1, col);
        
        return left + up;
    }
}
