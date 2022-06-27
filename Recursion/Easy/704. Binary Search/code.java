class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        return binarySearch(nums, target, s, e);
    }
    
    public int binarySearch(int[] nums, int target, int s, int e){
        while(s <= e){
            int mid = s + (e - s)/2;
            if(nums[mid] < target){
                return binarySearch(nums, target, mid + 1, e);
            }else if(nums[mid] > target){
                return binarySearch(nums, target, s, mid - 1);
            }else{
                return mid;
            }
        }
        return -1;
    }
}
