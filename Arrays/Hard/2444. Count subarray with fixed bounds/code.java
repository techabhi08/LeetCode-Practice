class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int min = -1;
        int max = -1;
        int invalid = -1;
        long ans = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == minK){
                min = i;
            }
            if(nums[i] == maxK){
                max = i;
            }
            if(nums[i] < minK || nums[i] > maxK){
                invalid = i;
            }
            ans += Math.max(0, Math.min(min, max) - invalid);
        }
        return ans;
    }
}
