class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        findSets(0, nums, ans, new ArrayList<>());
        
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> item : ans){
            res.add(new ArrayList<>(item));
        }
        return res;
    }
    
    public void findSets(int index, int[] nums, Set<List<Integer>> ans, List<Integer> inner){
        if(index == nums.length){
            ans.add(new ArrayList<>(inner));
            return;
        }
        
        if(index < nums.length){
            inner.add(nums[index]);
            findSets(index + 1, nums, ans, inner);
            inner.remove(inner.size() - 1);
            findSets(index + 1, nums, ans, inner);
        }
    }
}