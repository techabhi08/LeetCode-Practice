class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(isEven(nums[i])){
                count++;
            }
        }
        return count;
    }
    
    public boolean isEven(int num){
        int count = 0;
        while(num != 0){
            num = num / 10;
            count++;
        }
        if(count % 2 == 0){
            return true;
        } else {
            return false;
        }
    }
}
