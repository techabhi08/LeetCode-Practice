class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        if(sum % 2 != 0){
            return false;
        }
        boolean[] prev = new boolean[sum / 2 + 1];
        prev[0] = true;
        if(nums[0] <= sum / 2){
            prev[nums[0]] = true;
        }
        
        for(int index = 1; index < n; index++){
            boolean[] curr = new boolean[sum / 2 + 1];
            for(int target = 1; target <= sum / 2; target++){
                boolean notTake = prev[target];
                boolean take = false;
                if(nums[index] <= target){
                    take = prev[target - nums[index]];
                }

                curr[target] = (take || notTake);
            }
            prev = curr;
        }
        return prev[sum / 2];
    }
}