class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        return findProfit(n - 1, nums);
    }
    
    public int findProfit(int index, int[] nums){
        if(index == 0){
            return nums[index];
        }
        
        if(index < 0){
            return 0;
        }
        
        int notPick = 0 + findProfit(index - 1, nums);
        int pick = nums[index] + findProfit(index - 2, nums);
        
        return Math.max(notPick, pick);
    }
}
