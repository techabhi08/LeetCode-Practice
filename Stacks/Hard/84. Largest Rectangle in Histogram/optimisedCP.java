class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        //Calculating the left smaller for every bar
        for(int i = 0; i <= heights.length; i++){
            while(!stack.isEmpty() && (i == heights.length || heights[stack.peek()] >= heights[i])){
                int height = heights[stack.peek()];
                stack.pop();
                int width;
                if(stack.isEmpty()){
                    width = i;
                }else{
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);

        }
        return maxArea;
    }
}
