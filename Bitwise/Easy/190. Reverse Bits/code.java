public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long result = 0;
        int x = 1;
        for(int i = 31; i >= 0; i--){
            if((n & x) != 0){
                result += Math.pow(2, i);
            }
            
            x = x << 1;
        }
        return (int)result;
        
        
    }
}
