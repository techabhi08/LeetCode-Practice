class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int curr = 0;
        
        while(curr <= right){
            if(nums[curr] == 0){
                swap(left, curr, nums);
                left++;
                curr++;
            }else if(nums[curr] == 1){
                curr++;
            }else if(nums[curr] == 2){
                swap(curr, right, nums);
                right--;
            }
        }
    }
    
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}