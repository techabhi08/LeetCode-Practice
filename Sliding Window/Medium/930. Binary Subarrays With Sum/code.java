class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return findSum(nums, goal) - findSum(nums, goal - 1);
    }
    
    public int findSum(int[] nums, int goal){
        int ans = 0;
        int left = 0;
        int sum = 0;
        
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            
            while(left <= right && sum > goal) {
                sum -= nums[left];
                left++;
            }
            
            ans += right - left + 1;
        }
        return ans;
    }
}
