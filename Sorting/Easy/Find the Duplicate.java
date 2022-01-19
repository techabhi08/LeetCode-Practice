class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i  < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
                // swap(nums, i, correct);
            }else {
                i++;
            }
        }
        
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j + 1){
                return nums[j];
            }
        }
        return 0;
    }
    
//     public void swap(int[] nums, int start, int end){
//         int temp = nums[start];
//         nums[start] = nums[end];
//         nums[end] = temp;
//     }
}
