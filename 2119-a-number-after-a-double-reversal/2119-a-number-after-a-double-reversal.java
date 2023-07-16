class Solution {
    public boolean isSameAfterReversals(int num) {
        if(num % 10 != 0 || num < 10){
            return true;
        }
        return false;
    }
}