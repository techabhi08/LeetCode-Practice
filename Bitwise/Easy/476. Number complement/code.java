class Solution {
    public int findComplement(int num) {
        int count = num;
        int x = 1;
        while(count != 0){
            num = (num ^ x);
            x = (x << 1);
            count = (count >> 1);
        }
        return num;
    }
}
