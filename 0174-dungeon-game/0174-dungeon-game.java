class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findMin(0, 0, dungeon, dp);
    }
    
    public int findMin(int row, int col, int[][] dungeon, int[][] dp){
        if(row >= dungeon.length || col >= dungeon[0].length){
            return Integer.MAX_VALUE;
        }
        
        if(row == dungeon.length - 1 && col == dungeon[0].length - 1){
            return Math.max(1, 1 - dungeon[row][col]);
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int down = findMin(row + 1, col, dungeon, dp);
        int right = findMin(row, col + 1, dungeon, dp);
        
        int res = Math.min(down, right) - dungeon[row][col];
        res = Math.max(1, res);
        
        return dp[row][col] = res;
    }
}