class Pair{
    int node;
    int weight;
    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        int[][] dist = new int[n][n];
        for(int[] row : dist){
            Arrays.fill(row, (int)1e9);
        }
        
        for(int src = 0; src < n; src++){
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
            pq.add(new Pair(src, 0));
            
            while(!pq.isEmpty()){
                Pair curr = pq.poll();
                int node = curr.node;
                int d = curr.weight;
                
                for(Pair item : adj.get(node)){
                    int adjNode = item.node;
                    int adjDist = item.weight;
                    if(adjDist + d < dist[src][adjNode]){
                        dist[src][adjNode] = adjDist + d;
                        pq.add(new Pair(adjNode, dist[src][adjNode]));
                    }
                }
            }
        }
        
        int ans = -1;
        int minCount = Integer.MAX_VALUE;
        
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
            if(count <= minCount){
                minCount = count;
                ans = i;
            }
        }
        return ans;
    }
}