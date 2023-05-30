class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] vis = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                count++;
                dfs(i, isConnected, vis);
            }
        }
        
        return count;
    }
    
    public void dfs(int node, int[][] isConnected, boolean[] vis){
        vis[node] = true;
        
        for(int i = 0; i < isConnected[node].length; i++){
            if(!vis[i] && isConnected[node][i] == 1){
                dfs(i, isConnected, vis);
            }
        }
    }
}