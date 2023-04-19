class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarrayWithSize(nums, k) - subarrayWithSize(nums, k - 1);
    }
    
    public int subarrayWithSize(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        
        for(int right = 0; right < nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            while(map.size() == k + 1){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            
            ans += right - left + 1;
        }
        return ans;
    }
}
