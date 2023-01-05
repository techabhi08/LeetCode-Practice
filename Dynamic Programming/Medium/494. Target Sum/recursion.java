class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        int s2 = (sum - target) / 2;
        
        if(sum - target < 0 || (sum - target) % 2 != 0){
            return 0;
        }
        
        return findWays(n - 1, nums, s2);
    }
    
    public int findWays(int index, int[] nums, int target){
        if(index == 0){
            if(target == 0 && nums[index] == 0){
                return 2;
            }
            if(target == 0 || nums[index] == target)
                return 1;
            return 0;
        }
        
        int take = 0;
        if(nums[index] <= target){
            take = findWays(index - 1, nums, target - nums[index]);
        }
        int notTake = findWays(index - 1, nums, target);
        
        return take + notTake;
    }
}
