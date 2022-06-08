class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int sum = 0;
        // int[] index = new int[2];
        // for(int i = 1; i < nums.length; i++){
        //     for(int j = 0; j < i; j++){
        //         if(nums[i] + nums[j] == target){
        //             index[0] = i;
        //             index[1] = j;
        //         }
        //     }
        // }
        // return index;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int required = target - nums[i];
            if(map.containsKey(required)){
                int[] ans =  {map.get(required), i};
                return ans;
            }else{
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
