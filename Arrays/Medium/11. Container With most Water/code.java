class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while(left < right){
            int width = right - left;
            int heights = Math.min(height[left], height[right]);
            
            int area = width * heights;
            maxArea = Math.max(maxArea, area);
            
            if(height[left] < height[right]){
                left++;
            }else if(height[left] > height[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }
        return maxArea;
    }
}
