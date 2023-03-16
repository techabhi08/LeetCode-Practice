class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        return findSum(nums, n);
    }
    
    public int findSum(int[] nums, int n){
        if(n == 1) return nums[0];
        
        for(int i = 0; i < n - 1; i++){
            nums[i] = (nums[i] + nums[i + 1]) % 10;
        }
        
        
        return findSum(nums, n - 1);
    }
}
