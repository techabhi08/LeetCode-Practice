class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        returnPermutations(new ArrayList<>(), ans, nums);
        return ans;
    }
    
    public void returnPermutations(List<Integer> temp, List<List<Integer>> ans, int[] nums){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!temp.contains(nums[i])){
                temp.add(nums[i]);
                returnPermutations(temp, ans, nums);
                temp.remove(temp.size() - 1);
            }
            
        }

    }
}
