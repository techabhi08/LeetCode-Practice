class Solution {
    int MOD = 1000000007;
    
    public int countGoodNumbers(long n) {
        long even = (n % 2 == 0) ? (n / 2) : (n / 2) + 1;
        long odd = (n / 2);
        int ans = 1;
        
        ans = (int)(pow(5, even) * pow(4, odd) % MOD);
        return ans;
    }
    
    public long pow(long num, long power){
        if(power == 0){
            return 1;
        }
        long temp = pow(num, power / 2);
        
        if(power % 2 == 0){
            return (temp * temp) % MOD;
        }
        return (num * temp * temp) % MOD;
    }
}
