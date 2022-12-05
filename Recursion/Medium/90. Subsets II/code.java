class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        findSubsets(0, nums, new ArrayList<>(), set);
        
        List<List<Integer>> list = new ArrayList<>();
        for(List<Integer> item : set){
            list.add(new ArrayList<>(item));
        }
        return list;
    }
    
    public void findSubsets(int index, int[] nums, List<Integer> inner, Set<List<Integer>> set){
        if(index == nums.length){
            set.add(new ArrayList<>(inner));
            return;
        }
        
        if(index < nums.length){
            inner.add(nums[index]);
            findSubsets(index + 1, nums, inner, set);
        
            inner.remove(inner.size() - 1);
        }
        findSubsets(index + 1, nums, inner, set);
    }
}
