class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int num : nums){
            sum += num;
            
            int temp = sum % k;
            if(temp < 0){
                temp += k;
            }
            
            if(map.containsKey(temp)){
                ans += map.get(temp);
                map.put(temp, map.get(temp) + 1);
            }
            
            map.putIfAbsent(temp, 1);
        }
        
        return ans;
    }
}
