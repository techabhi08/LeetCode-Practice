class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        Map<String, Double> dp = new HashMap<>();
        return (double)solve(n, k, row, column, dp) / Math.pow(8, k);
    }
    
    public double solve(int n, int k, int row, int col, Map<String, Double> dp){
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
        
        double a1 = solve(n, k - 1, row - 2, col - 1, dp);
        double a2 = solve(n, k - 1, row - 1, col - 2, dp);
        double a3 = solve(n, k - 1, row + 1, col - 2, dp);
        double a4 = solve(n, k - 1, row + 2, col - 1, dp);
        
        double a5 = solve(n, k - 1, row + 2, col + 1, dp);
        double a6 = solve(n, k - 1, row + 1, col + 2, dp);
        double a7 = solve(n, k - 1, row - 1, col + 2, dp);
        double a8 = solve(n, k - 1, row - 2, col + 1, dp);
        
        double res = a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8;
        dp.put(key, res);
        return res;
    }
}