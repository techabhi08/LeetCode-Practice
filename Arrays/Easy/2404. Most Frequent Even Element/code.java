class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int num = 1000000;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if((map.get(nums[i]) > max) || map.get(nums[i])== max && nums[i] < num){
                    max = map.get(nums[i]);
                    num = nums[i];
                }
            }
        }
        return max == 0 ? -1 : num;
    }
}
