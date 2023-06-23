class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        
        for(int num : nums){
            if(num != 0){
                nums[i++] = num;
            }
        }
        
        for(int j = i; j < n; j++){
            nums[j] = 0;
        }
    }
}