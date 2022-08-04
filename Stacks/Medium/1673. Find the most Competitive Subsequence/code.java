class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(stack.isEmpty()){
                stack.push(nums[i]);
            }
            
            int reminder = nums.length - i - 1;
            
            while(!stack.isEmpty() && nums[i] < stack.peek() && stack.size() + reminder >= k){
                stack.pop();
            }
            
            if(stack.size() < k){
                stack.push(nums[i]);
            }
        }
        
        int[] res = new int[k];
        int i = k - 1;
        while(!stack.isEmpty()){
            res[i--] = stack.pop();
        }
        return res;
    }
}
