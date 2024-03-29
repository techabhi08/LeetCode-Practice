class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = (int)1e9 + 7;
        long[] shares = new long[n + 1];
        long[] forgets = new long[n + 1];
        
        if(delay < n){
            shares[delay + 1] = 1;
        }
        if(forget < n){
            forgets[forget + 1] = 1;
        }
        
        long shareToday = 0;
        long peopleKnow = 1;
        
        for(int i = delay; i <= n; i++){
            shareToday += shares[i] % mod;
            shareToday -= forgets[i] % mod;
            
            peopleKnow -= forgets[i] % mod;
            peopleKnow += shareToday % mod;
            
            if(i + delay <= n){
                shares[i + delay] += shareToday % mod;
            }
            if(i + forget <= n){
                forgets[i + forget] += shareToday % mod;
            }
        }
        
        return (int)(peopleKnow % mod);
    }
}