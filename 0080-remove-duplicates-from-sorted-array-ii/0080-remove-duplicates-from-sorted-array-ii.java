class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            int count = 1;
            while(i + 1 < nums.length && nums[i] == nums[i + 1]){
                i++;
                count++;
            }
            nums[j] = nums[i];
            if(count >= 2){
                nums[++j] = nums[i];
            }
            j++;
        }
        return j;
    }
}