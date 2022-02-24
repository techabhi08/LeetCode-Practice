class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public boolean solve(char[][] board){
         int n = board.length;
        int row = 0;
        int col = 0;

        boolean notEmpty = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.'){
                    row = i;
                    col = j;
                    notEmpty = false;
                    break;
                }
            }
            //here we have traversed through the entire row hence
            // checking if some empty element is found then break
            if(!notEmpty){
                break;
            }
        }
        if(notEmpty == true){
            return true;
        }

        //now we are backtracking
        for(int num = 1; num <= 9; num++){
            if(isSafe(board, row, col, (char)(num + '0'))){
                board[row][col] = (char)(num + '0');
                if(solve(board)){
                    //this means we have found the answer
                    return true;
                } else {
                    //backtrack
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    
    

    public boolean isSafe(char[][] board, int row, int col, char num){
        for(int i = 0; i < board.length; i++){
            //checking if the same number exist in the row
            if(board[row][i] == num){
                return false;
            }
        }

        for(int i = 0; i < board.length; i++){
            //checking in every row for the same column.
            if(board[i][col] == num){
                return false;
            }
        }

        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for(int r = rowStart; r < rowStart + sqrt; r++){
            for(int c = colStart; c < colStart + sqrt; c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }

        return true;
    }
}
