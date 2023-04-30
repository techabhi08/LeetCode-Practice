class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums.length == 0){
            return ans;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == first){
                count1++;
            }else if(nums[i] == second){
                count2++;
            }
            
            else if(count1 == 0){
                first = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                second = nums[i];
                count2 = 1;
            }
            
            else{
                count1--;
                count2--;
            }
        }
        
        count1 = count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == first){
                count1++;
            }else if(nums[i] == second){
                count2++;
            }
        }
        
        if(count1 > nums.length / 3){
            ans.add(first);
        }
        if(count2 > nums.length / 3){
            ans.add(second);
        }
        return ans;
    }
}
