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
        
        int ans1 = findProfit(arr1.length - 1, arr1, dp);
        Arrays.fill(dp, -1);
        int ans2 = findProfit(arr2.length - 1, arr2, dp);
        return Math.max(ans1, ans2);
    }
    
    public int findProfit(int index, int[] arr, int[] dp){
        if(index == 0){
            return arr[index];
        }
        
        if(index < 0){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int take = arr[index] + findProfit(index - 2, arr, dp);
        int notTake = findProfit(index - 1, arr, dp);
        
        return dp[index] = Math.max(take, notTake);
    }
}