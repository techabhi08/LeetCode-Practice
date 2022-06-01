class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length == 1){
            return nums;
        }
        int first = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                // swap(nums, first, i);
                int temp = nums[first];
                nums[first] = nums[i];
                nums[i] = temp;
                first++;
            }
        }
        return nums;   
    }
}
