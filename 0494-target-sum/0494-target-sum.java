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
        
        return findTarget(n - 1, nums, s2);
    }
    
    public int findTarget(int index, int[] nums, int sum){
        if(index == 0){
            if(sum == 0 && nums[0] == 0) return 2;
            if(sum == 0 || nums[index] == sum) return 1;
            return 0;
        }
        
        int notTake = findTarget(index - 1, nums, sum);
        int take = 0;
        if(nums[index] <= sum){
            take = findTarget(index - 1, nums, sum - nums[index]);
        }
        
        return take + notTake;
    }
}