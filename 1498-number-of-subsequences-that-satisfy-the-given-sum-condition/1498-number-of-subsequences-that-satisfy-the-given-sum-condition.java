class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = (int)1e9+7;
        
        int[] power = new int[nums.length];
        power[0] = 1;
        for(int i = 1; i < nums.length; i++){
            power[i] = (power[i - 1] * 2) % mod;
        }
        
        int i = 0;
        int j = nums.length - 1;
        int ans = 0;
        
        while(i <= j){
            if(nums[i] + nums[j] <= target){
                ans = (ans + power[j - i]) % mod;
                i++;
            }else{
                j--;
            }
        }
        
        return ans;
    }
}