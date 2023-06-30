class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int left = findAns(nums, target, true);
        int right = findAns(nums, target, false);
        ans[0] = left;
        ans[1] = right;
        return ans;
        
        
    }
    
    public int findAns(int[] nums, int target, boolean isFirst){
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                ans = mid;
                if(isFirst){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
}