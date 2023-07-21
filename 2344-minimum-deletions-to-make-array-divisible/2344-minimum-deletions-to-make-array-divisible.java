class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(numsDivide);
        int gc = numsDivide[0];
        for(int i = 1; i < numsDivide.length; i++){
            gc = gcd(numsDivide[i], gc);
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(gc % nums[i] == 0){
                return i;
            }
        }
        return -1;
    }
    
    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        
        return gcd(b, a % b);
    }
}