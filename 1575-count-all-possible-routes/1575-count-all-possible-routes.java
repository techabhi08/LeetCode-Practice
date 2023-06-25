class Solution {
    int mod = (int)1e9 + 7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] dp = new int[n][fuel + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findPaths(locations, start, finish, fuel, dp);
    }
    
    public int findPaths(int[] locations, int start, int finish, int fuel, int[][] dp){
        if(fuel < 0){
            return 0;
        }
        
        if(dp[start][fuel] != -1){
            return dp[start][fuel];
        }
        int ans = start == finish ? 1 : 0;
        
        for(int i = 0; i < locations.length; i++){
            int cost = Math.abs(locations[i] - locations[start]);
            if(i != start && fuel - cost >= 0){
                ans = (ans + findPaths(locations, i, finish, fuel - cost, dp)) % mod;
            }
        }
        
        return dp[start][fuel] = ans;
    }
}