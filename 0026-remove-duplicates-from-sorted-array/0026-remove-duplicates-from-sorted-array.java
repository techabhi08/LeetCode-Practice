class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            while(j + 1 < nums.length && nums[j] == nums[j + 1]){
                j++;
            }
            nums[i] = nums[j];
            i++;
        }
        return i;
    }
}