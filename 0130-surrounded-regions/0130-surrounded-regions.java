class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O' && !vis[i][0]){
                dfs(i, 0, vis, board);
            }
            
            if(board[i][m - 1] == 'O' && !vis[i][m - 1]){
                dfs(i, m - 1, vis, board);
            }
        }
        
        for(int j = 0; j < m; j++){
            if(board[0][j] == 'O' && !vis[0][j]){
                dfs(0, j, vis, board);
            }
            
            if(board[n - 1][j] == 'O' && !vis[n - 1][j]){
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
        if(row >= 0 && row < board.length && col >= 0 && col < board[0].length && !vis[row][col] && board[row][col] == 'O'){
            vis[row][col] = true;
            dfs(row + 1, col, vis, board);
            dfs(row - 1, col, vis, board);
            dfs(row, col + 1, vis, board);
            dfs(row, col - 1, vis, board);
        }
    }
}