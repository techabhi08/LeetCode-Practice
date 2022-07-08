class Solution {
    public boolean hasAlternatingBits(int n) {
        int count = n & 1;
        while(n > 0){
            if(count != (n & 1)){
                return false;
            }
            n >>= 1;
            
            if(count == 1){
                count = 0;
            }else{
                count = 1;
            }
        }
        return true;
    }
}
