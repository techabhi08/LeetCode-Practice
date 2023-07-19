class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int max = -1;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == max){
                count++;
            }else if(count == 0){
                max = nums[i];
            }else{
                count--;
            }
        }
        
        count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == max){
                count++;
            }
        }
        
        return count > (nums.length / 2) ? max : -1;
    }
}