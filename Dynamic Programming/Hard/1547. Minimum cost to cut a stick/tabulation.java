class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        int index = 1;
        for(int num : cuts){
            arr[index++] = num;
        }
        
        int[][] dp = new int[m + 2][m + 2];
        
        for(int i = m; i >= 1; i--){
            for(int j = 1; j <= m; j++){
                if(i > j) continue;
                int min = (int)1e8;
                for(int k = i; k <= j; k++){
                    int cost = arr[j + 1] - arr[i - 1] + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][m];
    }
}
