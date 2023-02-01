class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        int index = 1;
        for(int num : nums){
            arr[index++] = num;
        }
        return findCoins(1, n, arr);
    }
    
    public int findCoins(int i, int j, int[] nums){
        if(i > j){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++){
            int coins = nums[i - 1] * nums[j + 1] * nums[k] + findCoins(i, k - 1, nums) + findCoins(k + 1, j, nums);
            max = Math.max(max, coins);
        }
        return max;
    }
}
