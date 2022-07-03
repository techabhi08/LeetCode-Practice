class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        returnArrayList(new ArrayList<>(), ans, nums, isVisited);
        return ans;
    }
    
    public void returnArrayList(List<Integer> temp, List<List<Integer>> ans, int[] nums, boolean[] isVisited){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
        }
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && !isVisited[i-1]){
                continue;
            }
            if(!isVisited[i]){
                temp.add(nums[i]);
                isVisited[i] = true;
                returnArrayList(temp, ans, nums, isVisited);
                isVisited[i] = false;
                temp.remove(temp.size() - 1);
            }
            
        }
    }
}
