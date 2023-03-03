class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        
        int n = nums.length;
        int target = n / 3;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > target){
                ans.add(nums[i]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int item : ans){
            list.add(item);
        }
        return list;
    }
}
