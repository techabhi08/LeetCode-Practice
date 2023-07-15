class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b ) -> a[0] - b[0]);
        int[][] dp = new int[events.length][k + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findMax(0, k, events, dp);
    }
    
    public int findMax(int index, int k, int[][] events, int[][] dp){
        if(k == 0 || index == events.length){
            return 0;
        }
        
        if(dp[index][k] != -1){
            return dp[index][k];
        }
        int i = binarySearch(index, events);
        
        return dp[index][k] = Math.max(findMax(index + 1, k, events, dp), events[index][2] + findMax(i, k - 1, events, dp));
    }
    
    public int binarySearch(int index, int[][] events){
        int low = index + 1;
        int high = events.length - 1;
        int ans = events.length;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(events[mid][0] > events[index][1]){
                ans = Math.min(mid, ans);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}