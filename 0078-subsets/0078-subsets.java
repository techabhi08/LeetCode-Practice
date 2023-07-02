class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSets(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    
    public void findSets(int index, int[] nums, List<Integer> inner, List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<>(inner));
            return;
        }
        
        inner.add(nums[index]);
        findSets(index + 1, nums, inner, ans);
        
        inner.remove(inner.size() - 1);
        findSets(index + 1, nums, inner, ans);
    }
}