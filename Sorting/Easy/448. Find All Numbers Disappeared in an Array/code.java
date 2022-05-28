class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else{
                i++;
            }
        }
        
        int j = 0;
        while(j < nums.length){
            if(nums[j] != j + 1){
                ans.add(j + 1);
            }
            j++;
        }
        return ans;
    }
}
