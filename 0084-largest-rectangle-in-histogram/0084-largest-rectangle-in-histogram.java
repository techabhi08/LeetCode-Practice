class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        
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
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        
        return max;
    }
}