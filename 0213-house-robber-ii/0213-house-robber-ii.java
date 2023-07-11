class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];
        int idx1 = 0;
        int idx2 = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(i != 0){
                arr1[idx1++] = nums[i];
            }
            if(i != n - 1){
                arr2[idx2++] = nums[i];
            }
        }
        
        int[] dp = new int[n - 1];
        Arrays.fill(dp, -1);
        
        int ans1 = findProfit(arr1, dp);
        Arrays.fill(dp, -1);
        int ans2 = findProfit( arr2, dp);
        return Math.max(ans1, ans2);
    }
    
    public int findProfit(int[] arr, int[] dp){
        dp[0] = arr[0];
        for(int index = 1; index < arr.length; index++){
            int take = arr[index];
            if(index - 2 >= 0){
                take += dp[index - 2];
            }
            int notTake = dp[index - 1];
            dp[index] = Math.max(take, notTake);
        }
        return dp[arr.length - 1];
    }
}