class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int n = nums.length / 2;
        
        int j = 1;
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                ans[k] = nums[i];
                k += 2;
            }else{
                ans[j] = nums[i];
                j += 2;
            }
        }
        return ans;
    }
}
