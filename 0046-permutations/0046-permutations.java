class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        returnPermutation(0, result, nums);
        return result;
    }
    
    public void returnPermutation(int index, List<List<Integer>> result, int[] nums){
        if(index == nums.length){
            List<Integer> inner = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                inner.add(nums[i]);
            }
            
            result.add(new ArrayList<>(inner));
            return;
        }
        
        for(int i = index; i < nums.length; i++){
            swap(i, index, nums);
            returnPermutation(index + 1, result, nums);
            swap(i, index, nums);
        }
    }
    
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}