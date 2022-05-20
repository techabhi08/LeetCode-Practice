class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int temp = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= temp;
            temp *= nums[i];
        }
        return answer;
    }
}
