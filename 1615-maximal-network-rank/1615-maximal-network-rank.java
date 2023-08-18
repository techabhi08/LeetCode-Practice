class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] road : roads){
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        
        int maxi = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int rank = adj.get(i).size() + adj.get(j).size();
                if(adj.get(i).contains(j) || adj.get(j).contains(i)){
                    rank--;
                }
                maxi = Math.max(maxi, rank);
            }
        }
        
        return maxi;
    }
}