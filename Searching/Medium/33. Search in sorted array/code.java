class Solution {
    public int search(int[] nums, int target) {
        int pivot = highestElement(nums);
        int result = binarySearch(nums, target, 0, pivot);
        if(result != -1){
            return result;
        }else{
            return binarySearch(nums, target, (pivot + 1), (nums.length - 1));
        }
    }
    
    public int highestElement(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end){
            int mid = start + (end - start) / 2;
            if(mid > start && nums[mid] < nums[mid - 1]){
                return mid - 1;
            } else if(mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            } else if(nums[mid] <= nums[start]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    
    public int binarySearch(int[] nums, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target < nums[mid]){
                end = mid - 1;
            }
            else if(target > nums[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
