class Solution {
    public int majorityElement(int[] nums) {
        int highest = Integer.MAX_VALUE;
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == highest){
                count++;
            }else if(count == 0){
                highest = nums[i];
            }else{
                count--;
            }
        }
        
        count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == highest){
                count++;
            }
        }
        
        if(count > nums.length / 2){
            return highest;
        }
        return -1;
    }
}