class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        int[] dRows = {-1, 1, 0, 0};
        int[] dCols = {0, 0, -1, 1};
        
        // checking for 0's on boundary
        
        for(int i = 0; i < m; i++){
            // first Row
            if(visited[0][i] == 0 && board[0][i] == 'O'){
                dfs(board, 0, i, visited, dRows, dCols);
            }
            
            // last Row
            if(visited[n - 1][i] == 0 && board[n - 1][i] == 'O'){
                dfs(board, n - 1, i, visited, dRows, dCols);
            }
        }
        
        for(int i = 0; i < n; i++){
            // first Col
            if(visited[i][0] == 0 && board[i][0] == 'O'){
                dfs(board, i, 0, visited, dRows, dCols);
            }
            
            // last Col
            if(visited[i][m - 1] == 0 && board[i][m - 1] == 'O'){
                dfs(board, i, m - 1, visited, dRows, dCols);
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void dfs(char[][] board, int row, int col, int[][] visited, int[] dRows, int[] dCols){
        visited[row][col] = 1;
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i < 4; i++){
            int nRow = row + dRows[i];
            int nCols = col + dCols[i];
            
            if(nRow >= 0 && nRow < n && nCols >= 0 && nCols < m && visited[nRow][nCols] == 0 && board[nRow][nCols] == 'O'){
                dfs(board, nRow, nCols, visited, dRows, dCols);
            }
        }
    }
}
