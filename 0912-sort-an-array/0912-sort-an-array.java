class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(0, nums.length, nums);
        return nums;
    }
    
    public void mergeSort(int start, int end, int[] nums){
        if(end - start == 1){
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(start, mid, nums);
        mergeSort(mid, end, nums);
        merge(start, mid, end, nums);
    }
    
    public void merge(int start, int mid, int end, int[] nums){
        int[] merged = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;
        
        while(i < mid && j < end){
            if(nums[i] < nums[j]){
                merged[k] = nums[i];
                i++;
            }else{
                merged[k] = nums[j];
                j++;
            }
            k++;
        }
        
        while(i < mid){
            merged[k++] = nums[i++];
        }
        while(j < end){
            merged[k++] = nums[j++];
        }
        
        for(int l = 0; l < merged.length; l++){
            nums[l + start] = merged[l];
        }
    }
}