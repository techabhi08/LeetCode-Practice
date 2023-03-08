class Solution {
    public int[] constructRectangle(int area) {
        int sqrt = (int)Math.sqrt(area);
        int[] ans = new int[2];
        
        for(int i = sqrt; i >= 1; i--){
            if(area % i == 0){
                int num1 = i;
                int num2 = area / i;
                ans[0] = Math.max(num1, num2);
                ans[1] = Math.min(num1, num2);
                return ans;
            }
        }
        
        return new int[]{area, 1};
    }
}
