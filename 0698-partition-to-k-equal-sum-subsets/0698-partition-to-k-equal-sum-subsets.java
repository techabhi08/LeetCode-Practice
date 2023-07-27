class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        if(sum % k != 0){
            return false;
        }
        Arrays.sort(nums);
        return findSubsets(nums.length - 1, k, 0, sum / k, new boolean[nums.length], nums);
    }
    
    public boolean findSubsets(int index, int k, int sum, int target, boolean[] vis, int[] nums){
        if(k == 0){
            return true;
        }
        
        if(sum == target){
            return findSubsets(nums.length - 1, k - 1, 0, target, vis, nums);
        }
        
        for(int i = index; i >= 0; i--){
            if(vis[i]){
                continue;
            }
            
            if(i + 1 < nums.length && nums[i] == nums[i + 1] && !vis[i + 1]){
                continue;
            }
            
            if(sum + nums[i] > target){
                continue;
            }
            
            vis[i] = true;
            if(findSubsets(i - 1, k, sum + nums[i], target, vis, nums)){
                return true;
            }
            vis[i] = false;
        }
        return false;
    }
}