class Pair{
    int node;
    int dist;
    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < roads.length; i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(0, 0));
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        long[] ways = new long[n];
        ways[0] = 1;
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int d = curr.dist;
            
            for(Pair item : adj.get(node)){
                int adjDist = item.dist;
                int adjNode = item.node;
                
                if(adjDist + d < dist[adjNode]){
                    dist[adjNode] = adjDist + d;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }else if(adjDist + d == dist[adjNode]){
                    ways[adjNode] += ways[node];
                    ways[adjNode] %= (int)1e9 + 7;
                }
            }
        }
        return (int)ways[n - 1];
    }
}