class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        Arrays.sort(nums);
        return findSum(nums.length - 1, sum / 2, nums);
    }
    
    public boolean findSum(int index, int target, int[] nums){
        if(index == 0){
            return nums[index] == target;
        }
        
        if(target == 0){
            return true;
        }
        
        boolean take = false;
        if(target >= nums[index]){
            take = findSum(index - 1, target - nums[index], nums);
        }
        boolean notTake = findSum(index - 1, target, nums);
        
        return take || notTake;
    }
}
