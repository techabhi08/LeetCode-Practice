class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaA = (ay2 - ay1) * (ax2 - ax1);
        int areaB = (by2 - by1) * (bx2 - bx1);
        
        int leftOverlap = Math.max(ax1, bx1);
        int rightOverlap = Math.min(ax2, bx2);
        int xOverlap = rightOverlap - leftOverlap;
        
        int upOverlap = Math.min(ay2, by2);
        int downOverlap = Math.max(ay1, by1);
        int yOverlap = upOverlap - downOverlap;
        
        int overlapArea = (xOverlap > 0 && yOverlap > 0) ? xOverlap * yOverlap : 0;
        
        return areaA + areaB - overlapArea;
    }
}
