class Solution {
    public int findMinArrowShots(int[][] points) {
        int arrows = 1;
        Arrays.sort(points, (int[] x , int[] y) -> {
            return x[0] < y[0] ? -1 : 1;
        });
        
        int end = points[0][1];
        for(int i = 0; i < points.length; i++){
            if(points[i][0] <= end){
                end = Math.min(points[i][1], end);
            }else{
                end = points[i][1];
                arrows++;
            }
        }
            
        return arrows;
    }
}
