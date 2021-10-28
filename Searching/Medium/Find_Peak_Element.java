class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int target = 0;
        while(start < end){
            int mid = start + (end - start)/2;
            target = nums[mid];
            if(target < nums[mid + 1]){
                start = mid +1;
            } else if(target > nums[mid + 1]){
                end = mid;
            }else{
                return mid;
            }
        }
        return start;
    }
}
