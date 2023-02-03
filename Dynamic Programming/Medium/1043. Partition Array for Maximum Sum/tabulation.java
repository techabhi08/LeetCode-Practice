class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        
        for(int index = n - 1; index >= 0; index--){
            int max = Integer.MIN_VALUE;
            int result = 0;
            int len = 0;
            for(int j = index; j < Math.min(arr.length, index + k); j++){
                len++;
                max = Math.max(max, arr[j]);
                int sum = len * max + dp[j + 1];
                result = Math.max(result, sum);
            }

            dp[index] = result;
        }
        return dp[0];
    }
}
