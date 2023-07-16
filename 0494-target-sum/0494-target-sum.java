class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total += num;
        }
        
        int s2 = (total - target) / 2;
        if(total - target < 0 || (total - target) % 2 != 0){
            return 0;
        }
        
        return findMin(n - 1, s2, nums);
    }
    
    public int findMin(int index, int target, int[] nums){
        if(index == 0){
            if(target == 0 && nums[index] == 0){
                return 2;
            }
            if(target == 0 || nums[index] == target){
                return 1;
            }
            return 0;
        }
        
        int notTake = findMin(index - 1, target, nums);
        int take = 0;
        if(nums[index] <= target){
            take = findMin(index - 1, target - nums[index], nums);
        }
        
        return take + notTake;
    }
}