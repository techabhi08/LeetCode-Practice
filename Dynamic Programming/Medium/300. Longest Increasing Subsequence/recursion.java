class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return findLIS(0, -1, nums);
    }
    
    public int findLIS(int index, int prev, int[] nums){
        if(index == nums.length){
            return 0;
        }
        
        int take = 0;
        if(prev == -1 || nums[prev] < nums[index]){
            take = 1 + findLIS(index + 1, index, nums);
        }
        int notTake = findLIS(index + 1, prev, nums);
        
        return Math.max(take, notTake);
    }
}
