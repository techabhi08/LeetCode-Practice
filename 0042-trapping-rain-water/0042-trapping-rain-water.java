class Solution {
    public int trap(int[] height) {
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        
        int rightMax = 0;
        for(int i = height.length - 1; i >= 0; i--){
            rightMax = Math.max(rightMax, height[i]);
            suffix[i] = rightMax;
        }
        
        int leftMax = 0;
        for(int i = 0; i < height.length; i++){
            leftMax = Math.max(leftMax, height[i]);
            prefix[i] = leftMax;
        }
        
        int water = 0;
        for(int i = 0; i < height.length; i++){
            water += Math.min(suffix[i], prefix[i]) - height[i];
        }
        return water;
    }
}