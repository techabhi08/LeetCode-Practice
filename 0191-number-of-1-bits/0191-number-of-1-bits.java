public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int setBitCount = 0;
        
        for(int i = 31; i >= 0; i--){
            if((n & 1) == 1){
                setBitCount++;
            }
            n = n >> 1;
        }
        return setBitCount;
    }
}