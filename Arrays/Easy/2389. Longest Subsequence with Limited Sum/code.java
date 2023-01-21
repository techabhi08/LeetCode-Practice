class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int m = queries.length;
        int n = nums.length;
        int[] ans = new int[m];
        Arrays.sort(nums);

        for(int i = 1; i < n; i++){
            nums[i] = nums[i - 1] + nums[i];
        }
        
        int j = 0;
        for(int i = 0; i < m; i++){
            while(j < n && nums[j] <= queries[i]){
                j++;
            }
            ans[i] = j;
            j = 0;
        }
        return ans;
    }
}
