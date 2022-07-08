class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int i = left; i <= right; i++){
            if(countBits1(i)){
                ans++;
            }
        }
        return ans;
    }
    
    public boolean countBits1(int n){
        int count = 0;
        while(n > 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        if(count < 2){
            return false;
        }
        for(int i = 2; i * i <= count; i++){
            if(count % i == 0){
                return false;
            }
        }
        return true;
    }
}
