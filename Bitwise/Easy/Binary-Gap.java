class Solution {
    public int binaryGap(int n) {
       int ans = 0;
        int count = 0;
        boolean isOne = false;
        while(n != 0){
            if((n & 1) == 1){
                isOne = true;
                ans = Math.max(ans, count);
                count = 0;
            }
            if(isOne){
                count++;
            }
            n = n >> 1;
        }
        return ans;
    }
}
