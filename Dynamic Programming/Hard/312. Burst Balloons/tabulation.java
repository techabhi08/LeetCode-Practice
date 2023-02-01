class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        int index = 1;
        for(int num : nums){
            arr[index++] = num;
        }
        
        int[][] dp = new int[n + 2][n + 2];
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= n; j++){
                if(i > j) continue;
                int max = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++){
                    int coins = arr[i - 1] * arr[j + 1] * arr[k] +dp[i][k - 1]+dp[k + 1][j];
                    max = Math.max(max, coins);
                }
                dp[i][j] = max;
            }
        }
        
        
        return dp[1][n];
    }
}
