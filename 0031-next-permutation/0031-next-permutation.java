class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
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
            swap(index1, index2, nums);
        }
        reverse(nums, index1 + 1, n - 1);
        
    }
    
    public void swap(int i, int j, int[] nums){
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