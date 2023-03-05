class Solution {
    public boolean isUgly(int n) {
        for(int i = 2; i < 6; i++){
            while(n > 0 && n % i == 0){
                n /= i;
            }
        }
        return n == 1;
    }
}
