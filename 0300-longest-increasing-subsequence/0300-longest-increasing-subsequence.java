class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];
        
        for(int index = n - 1; index >= 0; index--){
            for(int prev = index - 1; prev >= -1; prev--){
                int take = 0;
                if(prev == -1 || nums[prev] < nums[index]){
                    take = 1 + next[index + 1];
                }
                int notTake = next[prev + 1];

                curr[prev + 1] = Math.max(take, notTake);
            }
            next = (int[])curr.clone();
        }
        return next[0];
    }
}