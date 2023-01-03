class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        int n = nums.length;

        boolean[] prev = new boolean[sum / 2 + 1];
        boolean[] curr = new boolean[sum / 2 + 1];
        
        if(nums[0] <= sum / 2) prev[nums[0]] = true;
        prev[0] = true;
        curr[0] = true;
        
        for(int index = 1; index < n; index++){
            for(int target = 1; target <= sum / 2; target++){
                boolean take = false;
                if(target >= nums[index]){
                    take = prev[target - nums[index]];
                }
                boolean notTake = prev[target];
                curr[target] = take || notTake;
            }
            prev = (boolean[])curr.clone();
        }
        
        return prev[sum / 2];
    }

}
