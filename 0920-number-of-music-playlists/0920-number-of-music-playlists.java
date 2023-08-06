class Solution {
    long mod = 1000000007;
    public int numMusicPlaylists(int N, int L, int K) {
        long dp[][] = new long[L+1][N+1];
        for(long d[]: dp) {
            Arrays.fill(d, -1);
        }
        return (int)helper(N, L, K, dp, 0, 0);

    }

    public long helper(int n, int l, int k, long dp[][], int len, int num) {

        if(len>l || num>n) {
            return 0;
        }
        if(len==l) {
            if(num==n) {
                return 1;
            }
            return 0;
        }

        if(dp[len][num]!=-1) {
            return dp[len][num];
        }

        long ans = (helper(n, l, k, dp, len+1, num)*Math.max(0, num-k))%mod;
        ans += (helper(n, l, k, dp, len+1, num+1)*(n-num))%mod;
        ans = ans%mod;
        return dp[len][num] = ans;
    }
}