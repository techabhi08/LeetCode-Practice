class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int rightMax = 0;
        int leftMax = 0;
        int water = 0;
        
        while(left <= right){
            if(height[left] <= height[right]){
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left++];
            }else{
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right--];
            }
        }
        return water;
    }
}