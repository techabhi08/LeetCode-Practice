class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Method 1
        // boolean swapped;
        // for(int i = 0; i < nums.length; i++){
        //     swapped = false;
        //     for(int j = i + 1; j < nums.length; j++){
        //         if(nums[j] < nums[j - 1]){
        //             swapped = true;
        //             int temp = nums[j];
        //             nums[j] = nums[j - 1];
        //             nums[j - 1] = temp;
        //         }
        //     }
        //     if(!swapped){
        //         break;
        //     }
        // }
        
        // Method 2
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                return true;
            }
        }
        return false;
    }
}
