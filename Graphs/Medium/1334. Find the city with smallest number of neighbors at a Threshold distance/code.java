class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = (int)1e9;
            }
        }
        
        for(int[] edge : edges){
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        int minCity = Integer.MAX_VALUE;
        int ans = -1;
        
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                if(dist[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= minCity){
                minCity = count;
                ans = i;
            }
        }
        return ans;
    }
}
