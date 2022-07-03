class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        queens(result, board, 0);
        return result;
    }
    
    public void queens(List<List<String>> result, char[][] board, int row){
        if(row == board.length){
            display(result, board);
            return;
        }
        
        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                queens(result, board, row + 1);
                board[row][col] = '.';
            }
        }
    }
    
    public boolean isSafe(char[][] board, int row, int col){
        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        
        int maxLeft = Math.min(row, col);
        for(int i = 0; i <= maxLeft; i++){
            if(board[row - i][col - i] == 'Q'){
                return false;
            }
        }
        
        int maxRight = Math.min(row, board.length - col - 1);
        for(int i = 0; i <= maxRight; i++){
            if(board[row - i][col + i] == 'Q'){
                return false;
            }
        }
        return true;
    }
    
    public void display(List<List<String>> ans, char[][] board){
        List<String> eachRow = new ArrayList<>();
        String s = "";
        
        for(char[] ch : board){
            s = "";
            for(char c : ch){
                if(c == 'Q'){
                    s += 'Q';
                }else{
                    s += '.';
                }
            }
            eachRow.add(s);
        }
        ans.add(eachRow);
    }
}
