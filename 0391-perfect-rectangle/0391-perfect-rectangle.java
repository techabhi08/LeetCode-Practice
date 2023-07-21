class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> set = new HashSet<>();
        int area = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxA = Integer.MIN_VALUE;
        int maxB = Integer.MIN_VALUE;
        
        for(int i = 0; i < rectangles.length; i++){
            int x = rectangles[i][0];
            int y = rectangles[i][1];
            int a = rectangles[i][2];
            int b = rectangles[i][3];
            area += Math.abs(x - a) * Math.abs(y - b);
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxA = Math.max(maxA, a);
            maxB = Math.max(maxB, b);
            
            String bottomLeft = x + ":" + y;
            String bottomRight = a + ":" + y;
            String topLeft = x + ":" + b;
            String topRight = a + ":" + b;
            if(!set.contains(bottomLeft)){
                set.add(bottomLeft);
            }else{
                set.remove(bottomLeft);
            }
            
            if(!set.contains(bottomRight)){
                set.add(bottomRight);
            }else{
                set.remove(bottomRight);
            }
            
            if(!set.contains(topLeft)){
                set.add(topLeft);
            }else{
                set.remove(topLeft);
            }
            
            if(!set.contains(topRight)){
                set.add(topRight);
            }else{
                set.remove(topRight);
            }
        }
        
        String maxBottomLeft = minX + ":" + minY;
        String maxBottomRight = maxA + ":" + minY;
        String maxTopLeft = minX + ":" + maxB;
        String maxTopRight = maxA + ":" + maxB;
        int currArea = Math.abs(maxA - minX) * Math.abs(maxB - minY);
        
        if(!(set.size() == 4) || !set.contains(maxBottomLeft) || !set.contains(maxBottomRight) || !set.contains(maxTopLeft) || !set.contains(maxTopRight)){
            return false;
        }
        if(currArea == area){
            return true;
        }
        return false;
    }
}