class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        long[] sum = new long[n - 1];
        
        for(int i = 0; i < weights.length - 1; i++){
            sum[i] = weights[i] + weights[i + 1];
        }
        
        Arrays.sort(sum);
        long min = 0;
        long max = 0;
        
        for(int i = 0; i < k - 1; i++){
            min += sum[i];
            max += sum[sum.length - i - 1];
        }
        return max - min;
    }
}