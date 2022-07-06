public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int x = 1;
        for(int i = 31; i >= 0; i--){
            if((n & x) != 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
