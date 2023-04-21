class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMin = nums[0];
        int minSum = nums[0];
        int currMax = nums[0];
        int maxSum = nums[0];
        int totalSum = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            totalSum += nums[i];
            currMin = Math.min(currMin + nums[i], nums[i]);
            minSum = Math.min(minSum, currMin);
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMax);
        }
        
        return totalSum == minSum ? maxSum : Math.max(maxSum, totalSum - minSum);
    }
}
