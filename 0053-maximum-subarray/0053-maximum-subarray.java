class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        
        for(int num : nums){
            sum += num;
            if(sum > maxi){
                maxi = sum;
            }
            
            if(sum < 0){
                sum = 0;
            }
            
        }
        return maxi;
    }
}