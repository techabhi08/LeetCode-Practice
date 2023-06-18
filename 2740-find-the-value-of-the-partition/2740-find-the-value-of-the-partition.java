class Solution {
    public int findValueOfPartition(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        
        for(int i = 1; i < n; i++){
            ans = Math.min(ans, Math.abs(nums[i] - nums[i - 1]));
        }
        return ans;
    }
}