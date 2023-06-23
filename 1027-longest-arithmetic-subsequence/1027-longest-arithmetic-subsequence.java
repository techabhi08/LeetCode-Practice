class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map[] = new HashMap[n];
        map[0] = new HashMap<>();
        
        int max = 1;
        for(int i = 1; i < n; i++){
            map[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                int diff = nums[i] - nums[j];
                int count = map[j].getOrDefault(diff, 1);
                max = Math.max(max, count + 1);
                map[i].put(diff, count + 1);
            }
        }
        
        return max;
    }
}