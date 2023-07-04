class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        findQueens(0, board, ans);
        return ans;
    }
    
    public void findQueens(int row, char[][] board, List<List<String>> ans){
        if(row == board.length){
            displayBoard(board, ans);
            return;
        }
        
        for(int col = 0; col < board[0].length; col++){
            if(isValid(row, col, board)){
                board[row][col] = 'Q';
                findQueens(row + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }
    
    public boolean isValid(int row, int col, char[][] board){
        //check for vertical row
        for(int i = 0; i <= row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        
        //check for left diagonal
        for(int i = 0; i <= Math.min(row, col); i++){
            if(board[row - i][col - i] == 'Q'){
                return false;
            }
        }
        
        //check for right diagonal
        for(int i = 0; i <= Math.min(row, board[0].length - col - 1); i++){
            if(board[row - i][col + i] == 'Q'){
                return false;
            }
        }
        
        return true;
    }
    
    public void displayBoard(char[][] board, List<List<String>> ans){
        List<String> inner = new ArrayList<>();
        
        for(char[] ch : board){
            String s = "";
            
            for(char c : ch){
                if(c == 'Q'){
                    s += 'Q';
                }else{
                    s += '.';
                }
            }
            inner.add(s);
        }
        ans.add(inner);
    }
}