class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int ans = binarySearch(0, pivot, nums, target);
        if(ans != -1){
            return ans;
        }
        return binarySearch(pivot + 1, nums.length - 1, nums, target);
    }
    
    public int binarySearch(int start, int end, int[] nums, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
    
    public int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(end > mid && nums[mid] > nums[mid + 1]){
                return mid;
            }else if(mid > start && nums[mid] < nums[mid - 1]){
                return mid - 1;
            }else if(nums[start] >= nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return end;
    }
}