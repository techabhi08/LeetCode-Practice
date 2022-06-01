class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;
        int odd = 1;
        
        for(int i = 0; i < nums.length; i++){
            while(even < nums.length && nums[even] % 2 == 0){
                even += 2;
            }
            while(odd < nums.length && nums[odd] % 2 != 0){
                odd += 2;
            }
            if(even > nums.length || odd > nums.length){
                return nums;
            }
            else{
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
            }
        }
        return nums;
    }
}
