class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int num = sum % k;
            
            if(num == 0 && i > 0){
                return true;
            }
            
            if(map.containsKey(num) && i - map.get(num) > 1){
                return true;
            }
            
            if(!map.containsKey(num)){
                map.put(num, i);
            }
        }
        return false;
    }
}
