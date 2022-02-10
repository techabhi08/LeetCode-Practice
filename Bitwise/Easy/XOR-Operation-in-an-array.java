class Solution {
    public int xorOperation(int n, int start) {
        int sum = start;
        for(int i = 0; i < n;i++){
            if(i == 0){
                sum = sum ^ 0;
            }else{
                int num = start + 2*i;
                sum = (sum ^ num);
            }
        }
        return sum;
    }
}
