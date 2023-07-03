class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        findSets(0, nums, new ArrayList<>(), ans);
        
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> inner : ans){
            res.add(new ArrayList<>(inner));
        }
        return res;
    }
    
    public void findSets(int index, int[] nums, List<Integer> inner, Set<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<>(inner));
            return;
        }
        
        if(index < nums.length){
            inner.add(nums[index]);
            findSets(index + 1, nums, inner, ans);
            inner.remove(inner.size() - 1);
            findSets(index + 1, nums, inner, ans);
        }
    }
}