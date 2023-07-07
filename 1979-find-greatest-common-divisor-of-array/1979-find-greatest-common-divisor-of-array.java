class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        return findGCD(max, min);
    }
    
    public int findGCD(int a, int b){
        if(a == 0){
            return b;
        }
        return findGCD(b % a, a);
    }
}