class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> outer = new ArrayList<List<Integer>>();
        combinations(candidates, target, 0, outer, new ArrayList<>());
        return outer;
    }
    
    private void combinations(int[] nums, int target, int i, List<List<Integer>> ans,               
                              List<Integer>internal){
        if(target == 0){
            ans.add(new ArrayList<Integer>(internal));
            return;
        }
        
        if(target < 0 || i >= nums.length){
            return;
        }
        
        for(int k = i ; k < nums.length; k++){
            internal.add(nums[k]);
            combinations(nums, target-nums[k], k, ans, internal);
            internal.remove(internal.size() - 1);
        }
    }    
}
