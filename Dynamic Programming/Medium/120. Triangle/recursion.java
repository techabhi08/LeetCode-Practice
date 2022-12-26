class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        return findTotal(0, 0, triangle);
    }
    
    public int findTotal(int row, int col, List<List<Integer>> triangle){
        if(row == triangle.size() - 1){
            return triangle.get(row).get(col);
        }
        
        int down = triangle.get(row).get(col) + findTotal(row + 1, col, triangle);
        int diag = triangle.get(row).get(col) + findTotal(row + 1, col + 1, triangle);
        
        return Math.min(down, diag);
    }
}
