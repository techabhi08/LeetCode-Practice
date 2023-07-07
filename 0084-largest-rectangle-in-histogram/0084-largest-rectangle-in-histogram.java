class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];
        
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                leftMax[i] = 0;
            }
            else{
                leftMax[i] = stack.peek() + 1;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            stack.pop();
        }
        
        for(int i = heights.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                rightMax[i] = heights.length - 1;
            }else{
                rightMax[i] = stack.peek() - 1;
            }
            stack.push(i);
        }
        
        int ans = 0;
        for(int i = 0; i < heights.length; i++){
            ans = Math.max(ans, (rightMax[i] - leftMax[i] + 1) * heights[i]);
        }
        return ans;
    }
}