class Solution {
    public void nextPermutation(int[] nums) {
        int index1 = -1;
        int index2 = -1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                index1 = i;
                break;
            }
        }
        
        if(index1 >= 0){
            for(int i = nums.length - 1; i >= 0; i--){
                if(nums[i] > nums[index1]){
                    index2 = i;
                    break;
                }
            }
            swap(nums, index1, index2);
        }
        reverse(nums, index1 + 1, nums.length - 1);
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
