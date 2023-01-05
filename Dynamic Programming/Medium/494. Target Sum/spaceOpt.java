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
        int[] prev = new int[s2 + 1];
        int[] curr = new int[s2 + 1];
        
        if(nums[0] == 0){
            prev[0] = 2;
        }else{
            prev[0] = 1;
        }
        if(nums[0] != 0 && nums[0] <= s2){
            prev[nums[0]] = 1;
        }
        
        for(int index = 1; index < n; index++){
            for(int tar = 0; tar <= s2; tar++){
                int take = 0;
                if(nums[index] <= tar){
                    take = prev[tar - nums[index]];
                }
                int notTake = prev[tar];

                curr[tar] = take + notTake;
            }
            prev = (int[])curr.clone();
        }
        
        return prev[s2];
    }
    
}
