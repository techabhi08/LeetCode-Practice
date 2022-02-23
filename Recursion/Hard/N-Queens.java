class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        queens(ans, board, 0);
        return ans;
    }
    
    public void queens(List<List<String>> list, char[][] board, int row){
        if(row == board.length){
            display(list, board);
            return; 
        }
        
        for(int col = 0; col < board.length; col++){
            if(isSafe(list, board, row, col)){
                board[row][col] = 'Q';
                queens(list, board, row + 1);
                board[row][col] = '.';
            }
        }
    }
    
    public boolean isSafe(List<List<String>> list, char[][] board, int row, int col){
        //checking for vertical 
        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        
        //checking for diagonal left
        int maxLeft = Math.min(row, col);
        for(int i = 0; i <= maxLeft; i++){
            if(board[row - i][col - i] == 'Q'){
                return false;
            }
        }
        
        //checking for diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for(int i = 0; i <= maxRight; i++){
            if(board[row - i][col + i] == 'Q'){
                return false;
            }
        }
        
        return true;
    }
    
    public void display(List<List<String>> res, char[][] board){
        List<String> eachRow = new ArrayList<>();
        String s = "";
        
        for(int i = 0; i < board.length; i++){
            s = "";
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 'Q'){
                    s += 'Q';
                }else{
                    s+= '.';
                }
            }
            eachRow.add(s);
        }
        res.add(eachRow);
    }
}
