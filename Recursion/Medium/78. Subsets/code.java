class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), list);
        return list;
    }
    
    public void findSubsets(int index, int[] nums, List<Integer> inner, List<List<Integer>> list){
        if(index == nums.length){
            list.add(new ArrayList<>(inner));
        }
        
        if(index < nums.length){
            inner.add(nums[index]);
            findSubsets(index + 1, nums, inner, list);
            inner.remove(inner.size() - 1);
            findSubsets(index + 1, nums, inner, list);
        }
    }
}
