class Solution {
    public int jump(int[] nums) {
        int currJump = 0;
        int lastJump = 0;
        int count = 0;
        if(nums.length == 1){
            return count;
        }
        
        for(int i = 0; i < nums.length; i++){
            currJump = Math.max(currJump, i + nums[i]);
            
            if(i == lastJump){
                lastJump = currJump;
                count++;
                
                if(currJump >= nums.length - 1){
                    return count;
                }
            }
        }
        return count;
    }
}
