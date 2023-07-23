class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        int mod = (int)1e9 + 7;
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] - (int)rev(nums[i]);
        }
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                ans += map.get(nums[i]);
                ans %= mod;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        return (int)ans;
    }
    
    public int rev(int num){
        int ans = 0;
        
        while(num != 0){
            int rem = num % 10;
            ans = ans * 10 + rem;
            num /= 10;
        }
        return ans;
    }
}