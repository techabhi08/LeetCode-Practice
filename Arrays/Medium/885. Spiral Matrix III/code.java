class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int totalCells = rows * cols;
        int[][] result = new int[totalCells][2];
        
        int cellsVisited = 0;
        int stepSize = 1;
        int stepsMoved = 0;
        int direction = 0;
        
        while(cellsVisited < totalCells){
            if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols){
                result[cellsVisited][0] = rStart;
                result[cellsVisited][1] = cStart;
                cellsVisited++;
            }
            
            //Moving East
            if(direction == 0){
                cStart++;
            }
            //Moving south
            else if(direction == 1){
                rStart++;
            }
            //Moving west
            else if(direction == 2){
                cStart--;
            }
            //Moving North
            else if(direction == 3){
                rStart--;
            }
            stepsMoved++;
            
            if(stepsMoved == stepSize){
                stepsMoved = 0;
                direction++;
                
                if(direction == 2){
                    stepSize++;
                    stepsMoved = 0;
                }
                if(direction == 4){
                    stepSize++;
                    direction = 0;
                    stepsMoved = 0;
                }
            }
        }
        return result;
    }
}
