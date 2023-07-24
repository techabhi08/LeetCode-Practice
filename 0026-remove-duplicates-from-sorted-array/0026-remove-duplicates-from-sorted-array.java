class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            while(i + 1 < nums.length && nums[i] == nums[i + 1]){
                i++;
            }
            nums[j++] = nums[i];
        }
        return j;
    }
}