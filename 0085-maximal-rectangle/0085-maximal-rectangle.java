class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '0'){
                    heights[j] = 0;
                }else{
                    heights[j]++;
                }
            }
            max = Math.max(max, findArea(heights));
        }
        return max;
    }
    
    public int findArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        
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
                ans = Math.max(ans, width * height);
            }
            stack.push(i);
        }
        return ans;
    }
}