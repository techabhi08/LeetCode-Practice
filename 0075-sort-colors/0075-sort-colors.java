class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int twos = 0;
        
        for(int num : nums){
            if(num == 0){
                zero++;
            }else if(num == 1){
                one++;
            }else{
                twos++;
            }
        }
        int index = 0;
        while(index != nums.length){
            if(zero-- > 0) nums[index++] = 0;
            else if(one-- > 0) nums[index++] = 1;
            else nums[index++] = 2;
        }
    }
}