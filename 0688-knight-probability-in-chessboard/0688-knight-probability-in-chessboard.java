class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        Map<String, Double> dp = new HashMap<>();
        return (double)findKnight(n, k, row, column, dp) / Math.pow(8, k);
    }
    
    public double findKnight(int n, int k, int row, int col, Map<String, Double> dp){
        if(row < 0 || row >= n || col < 0 || col >= n){
            return 0;
        }
        
        String key = k + ":" + row + "-" + col;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        
        if(k == 0){
            return 1;
        }
        
        double a0 = findKnight(n, k - 1, row + 1, col + 2, dp);
        double a1 = findKnight(n, k - 1, row + 2, col + 1, dp);
        double a2 = findKnight(n, k - 1, row + 2, col - 1, dp);
        double a3 = findKnight(n, k - 1, row + 1, col - 2, dp);
        double a4 = findKnight(n, k - 1, row - 1, col - 2, dp);
        double a5 = findKnight(n, k - 1, row - 2, col - 1, dp);
        double a6 = findKnight(n, k - 1, row - 2, col + 1, dp);
        double a7 = findKnight(n, k - 1, row - 1, col + 2, dp);
        
        double result = a0 + a1 + a2 + a3 + a4 + a5 + a6 + a7;
        dp.put(key, result);
        return result;
    }
}