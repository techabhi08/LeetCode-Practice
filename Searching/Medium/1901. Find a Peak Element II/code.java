class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int startRow = 0;
        int endRow = mat.length - 1;
        
        while(startRow <= endRow){
            int mid = startRow + (endRow - startRow) / 2;
            int maxElement = maxElementIndex(mat[mid], mat[mid].length);
            
            //if the row is first row in the matrix
            if(mid == 0){
                //check only for element below.
                if(mat[mid][maxElement] > mat[mid + 1][maxElement]){
                    return new int[] {mid , maxElement};
                }
            }
            
            //if midrow is the last row in matrix then there are no below elements
            if(mid == mat.length - 1){
                if(mat[mid][maxElement] > mat[mid - 1][maxElement]){
                    return new int[]{mid, maxElement};
                }
            }
            
            //if midRow is in centre of the matrix
            else if(mid > 0 && mid < mat.length){
                if(mat[mid][maxElement] > mat[mid - 1][maxElement] && mat[mid][maxElement] > mat[mid + 1][maxElement]){
                    return new int[]{mid, maxElement};
                }
            }
            
            //if the element is smaller the element in next row
            if(mat[mid][maxElement] < mat[mid + 1][maxElement]){
                startRow = mid + 1;
            }else{
                endRow = mid - 1;
            }
        }
        //no result found
        return new int[]{-1, -1};
    }
    
    public int maxElementIndex(int[] arr, int n){
        int max = Integer.MIN_VALUE;
        int index = 0;
        
        for(int i = 0; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
                index = i;
            }
        }
        return index;
        
    }
}
