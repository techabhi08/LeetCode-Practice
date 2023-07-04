class Solution {
    boolean[][] vis;
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        vis = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(isPossible(i, j, board, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean isPossible(int i, int j, char[][] board, String word, int index){
        if(index == word.length()){
            return true;
        }
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || vis[i][j] == true || board[i][j] != word.charAt(index)){
            return false;
        }
        
        vis[i][j] = true;
        if(isPossible(i + 1, j, board, word, index + 1) || 
           isPossible(i - 1, j, board, word, index + 1) || 
          isPossible(i, j + 1, board, word, index + 1) || 
          isPossible(i, j - 1, board, word, index + 1)){
            return true;
        }
        
        vis[i][j] = false;
        return false;
        
    }
}