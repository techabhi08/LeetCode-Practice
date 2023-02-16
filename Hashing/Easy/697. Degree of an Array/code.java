class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> firstAppear = new HashMap<>();
        int maxFreq = 0;
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(!freq.containsKey(nums[i])){
                freq.put(nums[i], 1);
                firstAppear.put(nums[i], i);
                if(maxFreq == 0){
                    maxFreq = 1;
                    ans = 1;
                }
            }else{
                freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
                int f = freq.get(nums[i]);
                
                if(f > maxFreq){
                    maxFreq = f;
                    ans = i - firstAppear.get(nums[i]) + 1;
                }else if(f == maxFreq){
                    ans = Math.min(ans, i - firstAppear.get(nums[i]) + 1);
                }
            }
        }
        return ans;
    }
}
