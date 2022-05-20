class Solution {
    public boolean canJump(int[] nums) {
        int maxIndexReachable = 0;
        for (int i=0; i<nums.length; ++i) {
            if (i > maxIndexReachable) return false;
            maxIndexReachable = Math.max(maxIndexReachable, i + nums[i]);
        }
        return true;
    }
}
