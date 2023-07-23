class Solution {
    int mod = (int)1e9 + 7;
    public int numberOfWays(int n, int x) {
        List<Integer> powers = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            int num = (int)Math.pow(i, x);
            if(num <= n){
                powers.add(num);
            }else{
                break;
            }
        }
        
        int[][] dp = new int[powers.size() + 1][n + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findWays(0, n, powers, dp);
    }
    
    public int findWays(int index, int target, List<Integer> arr, int[][] dp){
        if(target == 0){
            return 1;
        }
        if(index == arr.size()){
            return 0;
        }
        
        if(dp[index][target] != -1){
            return dp[index][target];
        }
        
        int take = 0;
        if(arr.get(index) <= target){
            take = findWays(index + 1, target - arr.get(index), arr, dp) % mod;
        }
        int notTake = findWays(index + 1, target, arr, dp) % mod;
        
        return dp[index][target] = (take+ notTake) % mod;
    }
}