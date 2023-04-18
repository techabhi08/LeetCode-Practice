class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        int odds = 0;
        int result = 0;
        
        for(int right = 0; right < nums.length; right++){
            if(nums[right] % 2 != 0){
                odds++;
                ans = 0;
            }
            
            while(odds == k){
                ans++;
                if(nums[left] % 2 != 0){
                    odds--;
                }
                left++;
            }
            result += ans;
        }
        return result;
    }
}
