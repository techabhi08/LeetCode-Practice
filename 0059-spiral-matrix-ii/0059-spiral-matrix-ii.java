class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int rowS = 0;
        int rowE = n - 1;
        int colS = 0;
        int colE = n - 1;
        int num = 1;
        
        while(rowS <= rowE && colS <= colE){
            for(int i = colS; i <= colE; i++){
                ans[rowS][i] = num;
                num++;
            }
            rowS++;
            
            for(int i = rowS; i <= rowE; i++){
                ans[i][colE] = num;
                num++;
            }
            colE--;
            
            if(colS <= colE){
                for(int i = colE; i >= colS; i--){
                    ans[rowE][i] = num;
                    num++;
                }
                rowE--;
            }
            
            if(rowS <= rowE){
                for(int i = rowE; i >= rowS; i--){
                    ans[i][colS] = num;
                    num++;
                }
                colS++;
            }
        }
        return ans;
    }
}