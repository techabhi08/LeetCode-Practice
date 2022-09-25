class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length){
            if(nums[i] == target){
                list.add(i);
            }
            i++;
        }
        return list;
        
    }
}
