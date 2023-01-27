class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] ahead = new int[n + 1];
        int[] curr = new int[n + 1];
        
        for(int index = n - 1; index >= 0; index--){
            for(int prev = index - 1; prev >= -1; prev--){
                int take = 0;
                int notTake = ahead[prev + 1];
                if(prev == -1 || nums[prev] < nums[index]){
                    take = 1 + ahead[index + 1];
                }
                curr[prev + 1] = Math.max(take, notTake);
            }
            ahead = (int[])curr.clone();
        }
        return ahead[0];
    }
}
