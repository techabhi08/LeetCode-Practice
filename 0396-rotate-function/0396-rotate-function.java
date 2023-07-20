class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            f += i * nums[i];
        }
        
        int maxi = f;
        for(int i = nums.length - 1; i > 0; i--){
            maxi = Math.max(maxi, f + sum - (n * nums[i]));
            f = f + sum - (n * nums[i]);
        }
        return maxi;
    }
}