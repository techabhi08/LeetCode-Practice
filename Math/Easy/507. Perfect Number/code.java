class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        if(num <= 0){
            return false;
        }
        
        for(int i = 1; i * i <= num; i++){
            if(num % i == 0){
                sum += i;
                
                if(i * i != num){
                    sum += num / i;
                }
            }
        }
        if(sum - num == num){
            return true;
        }
        return false;
    }
}
