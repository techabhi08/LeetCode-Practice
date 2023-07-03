class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int max = 0;
        int left = 0;
        
        for(int right = 0; right < nums.length; right++){
            if(nums[right] % 2 == 0 && nums[right] <= threshold){
                left = right + 1;
                int count = 1;
                
                while(left < nums.length && nums[left] <= threshold){
                    if(nums[left] % 2 == 1 && nums[left - 1] % 2 == 0){
                        count++;
                        right++;
                        left++;
                    }else if(nums[left] % 2 == 0 && nums[left - 1] % 2 == 1){
                        count++;
                        right++;
                        left++;
                    }else{
                        max = Math.max(max, count);
                        break;
                    }
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}