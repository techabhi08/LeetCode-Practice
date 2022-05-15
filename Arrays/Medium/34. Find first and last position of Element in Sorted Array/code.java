class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[]{-1, -1};
        int start = binarySearch(nums, target, true);
        int end = binarySearch(nums, target, false);
        ans[0] = start;
        ans[1] = end;
        
        return ans;
    }
    
    public int binarySearch(int[] nums, int target, boolean isFirst){
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] < target){
                start = mid + 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                ans = mid;
                if(isFirst){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
