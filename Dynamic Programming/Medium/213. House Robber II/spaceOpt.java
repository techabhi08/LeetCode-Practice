class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] arr1 = new int[nums.length - 1];
        int[] arr2 = new int[nums.length - 1];
        int idx1 = 0, idx2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(i != 0){
                arr1[idx1++] = nums[i];
            }
            if(i != nums.length - 1){
                arr2[idx2++] = nums[i];
            }
        }
        int ans1 = helper(arr1);
        int ans2 = helper(arr2);
        return Math.max(ans1, ans2);
    }
    
    public int helper(int[] nums){
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        
        for(int i = 1; i < nums.length; i++){
            int pick = nums[i];
            if(i > 1){
                pick += prev2;
            }
            int notPick = 0 + prev;
            int curri = Math.max(pick, notPick);
            prev2 = prev;
            prev = curri;
        }
        
        return prev;
    }
}
