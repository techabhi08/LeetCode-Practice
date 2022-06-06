class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
//         int[] count = new int[101];
        
//         for(int i = 0; i < nums.length; i++){
//             count[nums[i]] += 1; 
//         }
        
//         for(int i = 1; i < 100; i++){
//             count[i] += count[i - 1];
//         }
        
//         for(int i = 0; i < nums.length; i++){
//             int index = nums[i];
//             if(index == 0){
//                 nums[i] = 0;
//             }else{
//                 nums[i] = count[index - 1];
//             }
//         }
//         return nums;
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[j] < nums[i] && j != i){
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}
