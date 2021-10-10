class Solution {
    public int maxSubArray(int[] nums) {
        int arr = nums[0];
        int maxSum = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(arr < 0){
                arr = 0;
            }
            
            arr += nums[i];
            
            if(arr > maxSum){
                maxSum = arr;
            }
        }
        return maxSum;
    }
}
