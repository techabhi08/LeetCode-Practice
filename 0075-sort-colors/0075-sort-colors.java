class Solution {
    public void sortColors(int[] nums) {
        int[] arr = new int[3];
        for(int num : nums){
            if(num == 0){
                arr[0]++;
            }else if(num == 1){
                arr[1]++;
            }else{
                arr[2]++;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(i < arr[0]){
                nums[i] = 0;
            }
            else if(i < arr[0] + arr[1]){
                nums[i] = 1;
            }else{
                nums[i] = 2;   
            }
        }
    }
}