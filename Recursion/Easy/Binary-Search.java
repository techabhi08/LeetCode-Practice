class Solution {
    public int search(int[] nums, int target) {
        int ans = binary(nums, 0, nums.length - 1, target);
        return ans;
    }
    
    public int binary(int[] nums, int start, int end, int target) {
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid] < target){
            return binary(nums, mid + 1, end, target);
        }else{
            return binary(nums, start, mid -1, target);
        }
    }
    
}
