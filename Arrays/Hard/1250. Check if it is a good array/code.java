class Solution {
    public boolean isGoodArray(int[] nums) {
        int gcd = 0;
        for(int i = 0; i < nums.length; i++){
            gcd = findGCD(gcd, nums[i]);
            if(gcd == 1){
                return true;
            }
        }
        return false;
    }
    
    public int findGCD(int a, int b){
        if(b == 0){
            return a;
        }
        return findGCD(b, a % b);
    }
}
