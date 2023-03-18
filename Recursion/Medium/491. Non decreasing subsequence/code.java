class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        findSeq(nums, 0, new ArrayList<>(), ans);
        return new ArrayList(ans);
    }
    
    public void findSeq(int[] nums, int index, List<Integer> inner, Set<List<Integer>> ans){
        if(index == nums.length){
            if(inner.size() >= 2){
                ans.add(new ArrayList<>(inner));
            }
            return;
        }
        
        if(inner.size() == 0 || nums[index] >= inner.get(inner.size() - 1)){
            inner.add(nums[index]);
            findSeq(nums, index + 1, inner, ans);
            inner.remove(inner.size() - 1);
        }
        findSeq(nums, index + 1, inner, ans);
    }
}
