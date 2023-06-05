class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length <= 2){
            return true;
        }
        
        int x = coordinates[0][0];
        int y = coordinates[0][1];
        
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        
        for(int i = 2; i < coordinates.length; i++){
            int x1 = coordinates[i][0];
            int y1 = coordinates[i][1];
            
            if((x1 - x2) * (y1 - y) != (x1 - x) * (y1 - y2)){
                return false;
            }
        }
        return true;
    }
}