class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            //checking for 0th col
            if(!vis[i][0] && board[i][0] == 'O'){
                dfs(i, 0, vis, board);
            }
            
            //checking for last col
            if(!vis[i][m - 1] && board[i][m - 1] == 'O'){
                dfs(i, m - 1, vis, board);
            }
        }
        
        for(int j = 0; j < m; j++){
            //checking for 0th row
            if(!vis[0][j] && board[0][j] == 'O'){
                dfs(0, j, vis, board);
            }
            
            //checking for last row
            if(!vis[n - 1][j] && board[n - 1][j] == 'O'){
                dfs(n - 1, j, vis, board);
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void dfs(int row, int col, boolean[][] vis, char[][] board){
        if(row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 'O' && !vis[row][col]){
            vis[row][col] = true;
            dfs(row + 1, col, vis, board);
            dfs(row - 1, col, vis, board);
            dfs(row, col + 1, vis, board);
            dfs(row, col - 1, vis, board);
        }
    }
}