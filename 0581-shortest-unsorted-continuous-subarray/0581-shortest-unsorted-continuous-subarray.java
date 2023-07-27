class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int left = nums.length;
        int right = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != temp[i]){
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }
        
        return right - left < 0 ? 0 : right - left + 1;
    }
}