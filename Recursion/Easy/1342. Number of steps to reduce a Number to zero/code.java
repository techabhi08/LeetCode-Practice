class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        // return findSteps(num, count);
        
        while(num != 0){
            if((num & 1) == 1){
                num -= 1;
            }else{
                num /= 2;
            }
            count++;
        }
        return count;
    }
    
    // public int findSteps(int n, int count){
        // if(n == 0){
        //     return count;
        // }
        // if(n % 2 == 0){
        //     return findSteps(n / 2, ++count);
        // }
        // return findSteps(n - 1, ++count);
    // }
}
