class Solution {
    public int bitwiseComplement(int n) {
        int num2 = n;
        int x = 1;
        if(n == 0){
            return 1;
        }
        while(num2 != 0){
            num2 = num2 >> 1;
            n = n ^ x;
            x = x << 1;
        }
        return n;
    }
}
