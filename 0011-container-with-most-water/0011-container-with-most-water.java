class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while(left < right){
            int width = right - left;
            int h = Math.min(height[right], height[left]);
            
            int area = width * h;
            maxArea = Math.max(maxArea, area);
            
            if(height[right] < height[left]){
                right--;
            }else if(height[right] > height[left]){
                left++;
            }else{
                right--;
                left++;
            }
        }
        return maxArea;
    }
}