class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> avail = new HashMap<>();
        HashMap<Integer, Integer> wanted = new HashMap<>();
        
        for(int i : nums){
            avail.put(i, avail.getOrDefault(i, 0) + 1);
        }
        
        for(int i = 0; i < nums.length; i++){
            if(avail.get(nums[i]) <= 0){
                continue;
            }else if(wanted.getOrDefault(nums[i], 0) > 0){
                avail.put(nums[i], avail.getOrDefault(nums[i], 0) - 1);
                wanted.put(nums[i], wanted.getOrDefault(nums[i], 0) - 1);
                wanted.put(nums[i] + 1, wanted.getOrDefault(nums[i] + 1, 0) + 1);
            }else if(avail.getOrDefault(nums[i], 0) > 0 && avail.getOrDefault(nums[i] + 1, 0) > 0 && avail.getOrDefault(nums[i] + 2, 0) > 0){
                avail.put(nums[i], avail.getOrDefault(nums[i], 0) - 1);
                avail.put(nums[i] + 1, avail.getOrDefault(nums[i] + 1, 0) - 1);
                avail.put(nums[i] + 2, avail.getOrDefault(nums[i] + 2, 0) - 1);
                wanted.put(nums[i] + 3, wanted.getOrDefault(nums[i] + 3, 0) + 1);
            }else{
                return false;
            }
        }
        return true;
    }
}