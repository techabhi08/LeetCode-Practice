class Solution {
    public int hammingDistance(int x, int y) {
        int counter = 0;
        int num = x ^ y;
        while(num != 0){
            if((num & 1) == 1){
                counter++;
            }
            num >>= 1;
        }
        return counter;
    }
}
