class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int mod = (int)1e9 + 7;
        for(int i = 0; i < s.length(); i++){
            nums[i] += d * (s.charAt(i) == 'R' ? 1 : -1);
        }
        
        long sum = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            sum += i * (long)nums[i] - (nums.length - i - 1) * (long)nums[i];
            sum %= mod;
        }
        
        return (int)sum;
    }
}