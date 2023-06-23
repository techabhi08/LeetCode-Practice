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
        int[][] dp = new int[m + 1][m + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findMin(1, m, arr, dp);
    }
    
    public int findMin(int i, int j, int[] arr, int[][] dp){
        if(i > j){ 
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++){
            int cost = arr[j + 1] - arr[i - 1] + findMin(i, k - 1, arr, dp) + findMin(k + 1, j, arr, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}