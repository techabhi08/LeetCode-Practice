class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return findMaxSum(0, k, arr, dp);
    }
    
    public int findMaxSum(int index, int k, int[] arr, int[] dp){
        if(index == arr.length){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int max = Integer.MIN_VALUE;
        int result = 0;
        int len = 0;
        for(int j = index; j < Math.min(arr.length, index + k); j++){
            len++;
            max = Math.max(max, arr[j]);
            int sum = len * max + findMaxSum(j + 1, k, arr, dp);
            result = Math.max(result, sum);
        }
        
        return dp[index] = result;
    }
}
