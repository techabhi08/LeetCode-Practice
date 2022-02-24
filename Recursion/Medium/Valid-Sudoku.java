class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(board[row][col] != '.'){
                    if(!isValid(board, row, col, board[row][col])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int row, int col, char num){
        for(int i = 0; i < board.length; i++){
            //checking if the same number exist in the row
            if(board[row][i] == num && i != col){
                return false;
            }
        }

        for(int i = 0; i < board.length; i++){
            //checking in every row for the same column.
            if(board[i][col] == num && i != row){
                return false;
            }
        }

        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for(int r = rowStart; r < rowStart + sqrt; r++){
            for(int c = colStart; c < colStart + sqrt; c++){
                if(board[r][c] == num && r != row && c != col){
                    return false;
                }
            }
        }

        return true;
    }

}
