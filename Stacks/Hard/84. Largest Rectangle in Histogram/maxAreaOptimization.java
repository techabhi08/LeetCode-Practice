class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] leftSmaller = new int[heights.length];
        int[] rightSmaller = new int[heights.length];
        
        //Calculating the left smaller for every bar
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
            }
            if(stack.isEmpty()){
                leftSmaller[i] = 0;
            }else{
                int top = stack.peek();
                leftSmaller[i] = top + 1;
            }
            stack.push(i);
        }
        
        //Clearing the stack to reuse
        while(!stack.isEmpty()){
            stack.pop();
        }
        //Calculating right smaller for each bar
        
        int maxArea = 0;
        for(int i = heights.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(i);
                rightSmaller[i] = heights.length - 1;
            }else{
                int top = stack.peek();
                rightSmaller[i] = top - 1;
            }
            stack.push(i);
            
            int width = rightSmaller[i] - leftSmaller[i] + 1;
            maxArea = Math.max(maxArea, width * heights[i]);
        }
        return maxArea;
    }
}
