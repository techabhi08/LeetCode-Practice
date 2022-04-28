class Solution {
    public int maximumWealth(int[][] accounts) {
        int[] acc = new int[accounts.length];
        int max = 0;
        for(int row = 0; row < accounts.length; row++){
            int wealth = 0;
            for(int col = 0; col < accounts[row].length; col++){
                wealth += accounts[row][col];
            }
            acc[row] = wealth;
        }
        for(int i = 0; i < acc.length; i++){
            if(acc[i] > max)
                max = acc[i];
        }
        return max;
    }
}
