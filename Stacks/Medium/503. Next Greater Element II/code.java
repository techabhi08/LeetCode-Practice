class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--){
            stack.push(nums[i]);
        }
        
        for(int i = nums.length - 1; i >= 0; i--){
            int num = nums[i];
            while(!stack.isEmpty() && stack.peek() <= num){
                stack.pop();
            }
            nums[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(num);
        }
        return nums;
    }
}
