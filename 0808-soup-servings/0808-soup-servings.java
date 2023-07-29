class Solution {
    public double soupServings(int n) {
        if(n >= 5000){
            return (double)1;
        }
        double[][] dp = new double[n + 1][n + 1];
        return findProb(n, n, dp);
    }
    
    public double findProb(int a, int b, double[][]dp){
        if(a <= 0 && b <= 0){
            return (double)0.5;
        }
        if(a <= 0){
            return 1.0;
        }
        if(b <= 0){
            return 0.0;
        }
        
        if(dp[a][b] > 0){
            return dp[a][b];
        }
        
        return dp[a][b] = 0.25 * (findProb(a - 100, b, dp) + findProb(a - 75, b - 25, dp) + findProb(a - 50, b - 50, dp) + findProb(a - 25, b - 75, dp));
    }
}