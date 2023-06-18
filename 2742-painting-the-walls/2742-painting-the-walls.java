class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = time.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findMin(0, 0, cost, time, dp);
    }
    
    public int findMin(int index, int t, int[] cost, int[] time, int[][] dp){
        if(t >= time.length){
            return 0;
        }
        if(index >= time.length){
            return 5 * (int)1e8 + 1;
        }
        
        if(dp[index][t] != -1){
            return dp[index][t];
        }
        
        int take = cost[index] + findMin(index + 1, t + time[index] + 1, cost, time, dp);
        int notTake = findMin(index + 1, t, cost, time, dp);
        
        return dp[index][t] = Math.min(take, notTake);
    }
}