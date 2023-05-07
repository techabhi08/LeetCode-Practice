class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        
        //checking for boundary zeroes
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O' && !vis[i][0]){
                dfs(i, 0, board, vis);
            }
            if(board[i][m - 1] == 'O' && !vis[i][m - 1]){
                dfs(i, m - 1, board, vis);
            }
        }
        
        for(int j = 0; j < m; j++){
            if(board[0][j] == 'O' && !vis[0][j]){
                dfs(0, j, board, vis);
            }
            if(board[n - 1][j] == 'O' && !vis[n - 1][j]){
                dfs(n - 1, j, board, vis);
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
    
    public void dfs(int i, int j, char[][] board, boolean[][] vis){
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length && !vis[i][j] && board[i][j] == 'O'){
            vis[i][j] = true;
            dfs(i + 1, j, board, vis);
            dfs(i - 1, j, board, vis);
            dfs(i, j + 1, board, vis);
            dfs(i, j - 1, board, vis);
        }
    }
}