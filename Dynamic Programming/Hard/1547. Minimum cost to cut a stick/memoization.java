class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        int i = 1;
        for(int num : cuts){
            arr[i++] = num;
        }
        
        int[][] dp = new int[m + 2][m + 2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findCost(1, m, arr, dp);
    }
    
    public int findCost(int i, int j, int[] arr, int[][] dp){
        if(i > j){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int min = (int)1e8;
        for(int k = i; k <= j; k++){
            int cost = arr[j + 1] - arr[i - 1] + findCost(i, k - 1, arr, dp) + findCost(k + 1, j, arr, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}
