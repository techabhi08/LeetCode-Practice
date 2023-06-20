class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n];
        sum[0] = nums[0];
        
        for(int i = 1; i < n; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
        
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        for(int i = k; i < n - k; i++){
            long res = (sum[i + k] - sum[i - k] + nums[i - k]) / (2 * k + 1);
            ans[i] = (int)res;
        }
        
        return ans;
    }
}