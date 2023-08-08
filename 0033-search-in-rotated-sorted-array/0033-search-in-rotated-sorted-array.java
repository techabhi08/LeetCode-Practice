class Solution {
    public int search(int[] nums, int target) {
        int peak = findPeak(nums);
        int ans = binarySearch(0, peak, nums, target);
        if(ans == - 1){
            return binarySearch(peak + 1, nums.length - 1, nums, target);
        }
        return ans;
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
    
    public int findPeak(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end){
            int mid = start + (end - start) / 2;
            if(mid > start && nums[mid] < nums[mid - 1]){
                return mid - 1;
            }else if(mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            }else if(nums[mid] <= nums[start]){ 
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}