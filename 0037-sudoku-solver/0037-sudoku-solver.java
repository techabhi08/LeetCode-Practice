class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public boolean solve(char[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean isEmpty = false;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.'){
                    row = i;
                    col = j;
                    isEmpty = true;
                }
            }
            if(isEmpty){
                break;
            }
        }
        
        if(!isEmpty){
            return true;
        }
        
        for(int i = 1; i <= 9; i++){
            if(isValid(row, col, (char)(i + '0'), board)){
                board[row][col] = (char)(i + '0');
                if(solve(board)){
                    return true;
                }else{
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    
    public boolean isValid(int row, int col, char num, char[][] board){
        //check for the row
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == num && i != row){
                return false;
            }
        }
        
        for(int i = 0; i < board[0].length; i++){
            if(board[row][i] == num && i != col){
                return false;
            }
        }
        
        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - (row % sqrt);
        int colStart = col - (col % sqrt);
        
        for(int i = rowStart; i < rowStart + 3; i++){
            for(int j = colStart; j < colStart + 3; j++){
                if(board[i][j] == num && i != row && j != col){
                    return false;
                }
            }
        }
        return true;
    }
}