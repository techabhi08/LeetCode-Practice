class Solution {
    public boolean canJump(int[] nums) {
        int canReach = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > canReach){
                return false;
            }
            canReach = Math.max(canReach, i + nums[i]);
        }
        return true;
    }
}