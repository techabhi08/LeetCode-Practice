class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] path = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(allPathsWithAlphabets(word, board, i, j, path, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean allPathsWithAlphabets(String word, char[][] maze, int r, int c, int[][]          path, int step){
        if(word.length() == step){
            return true;
        }

        
        if(r < 0 || c < 0 || r >= maze.length || c >= maze[0].length || path[r][c] == 1               || maze[r][c]!=word.charAt(step)){
            return false;
        }
        
        //This block is considered in the path hence set it to false;
        path[r][c] = 1;

    
        boolean ans = allPathsWithAlphabets(word, maze, r + 1, c, path, step+1) ||                               allPathsWithAlphabets(word, maze, r, c + 1, path, step+1) ||
        allPathsWithAlphabets(word, maze, r - 1, c, path, step+1 ) ||
        allPathsWithAlphabets(word, maze, r, c - 1, path, step+1);
        

        //Resetting the block back to true for the next path.
        //The functions is getting over here hence also removing the changes
        //done in this function call.
        path[r][c] = 0;
        return ans;
    }
}
