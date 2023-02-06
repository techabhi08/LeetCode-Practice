class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] scoreMapping = new int[n][2];
        
        for(int i = 0; i < n; i++){
            scoreMapping[i][0] = ages[i];
            scoreMapping[i][1] = scores[i];
        }
        
        Arrays.sort(scoreMapping, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[n];
        
        int maxi = 0;
        for(int i = 0; i < n; i++){
            dp[i] = scoreMapping[i][1];
            maxi = Math.max(maxi, dp[i]);
        }
        
        for(int index = 0; index < n; index++){
            for(int prev = index - 1; prev >= 0; prev--){
                if(scoreMapping[index][1] >= scoreMapping[prev][1]){
                    dp[index] = Math.max(dp[index], scoreMapping[index][1] + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[index]);
        }
        
        return maxi;
    }
}
