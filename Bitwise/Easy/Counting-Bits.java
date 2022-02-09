class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for(int i = 0; i <= n; i++){
            int sum = 0;
            int x = i;
            while(x != 0){
                x = x & (x - 1);
                sum++;
            }
            arr[i] = sum;
        }
        return arr;
    }
}
