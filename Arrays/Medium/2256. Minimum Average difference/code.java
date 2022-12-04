class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int avgDiff = Integer.MAX_VALUE;
        
        long[] prefixSum = new long[n + 1];
        long[] suffixSum = new long[n + 1];
        
        for(int i = 0; i < n; i++){
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        for(int i = n - 1; i >= 0; i--){
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }
        
        for(int index = 0; index < n; index++){
            long leftAverage = prefixSum[index + 1];
            leftAverage /= index + 1;
            
            long rightAverage = suffixSum[index + 1];
            if(index != n - 1){
                rightAverage /= n - index - 1;
            }
            
            int diff = (int)Math.abs(rightAverage - leftAverage);
            if(diff < avgDiff){
                avgDiff = diff;
                ans = index;
            }
        }
        return ans;
    }
}
