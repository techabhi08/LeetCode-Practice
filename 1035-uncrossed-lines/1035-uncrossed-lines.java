class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findMax(0, 0, nums1, nums2, dp);
    }
    
    public int findMax(int i, int j, int[] nums1, int[] nums2, int[][] dp){
        if(i == nums1.length || j == nums2.length){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int count = 0;
        if(nums1[i] == nums2[j]){
            count += 1 + findMax(i + 1, j + 1, nums1, nums2, dp);
        }else{
            count += Math.max(findMax(i + 1, j, nums1, nums2, dp), findMax(i, j + 1, nums1, nums2, dp));
        }
        
        return dp[i][j] = count;
    }
}