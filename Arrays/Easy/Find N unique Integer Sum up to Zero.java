class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int i = 1;
        int l = 0;
        int h = n-1;
        while(l <= h){
            if(l == h){
                arr[l] = 0;
            } 
            else if(l < h){
                arr[l] = i;
                arr[h] = -i;
            }
            i++;
            l++;
            h--;
        }
        return arr;
    }
}
