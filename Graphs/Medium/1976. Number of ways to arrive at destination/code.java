class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int i = 0 ; i < roads.length ; i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1] , roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0] , roads[i][2]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x , y) -> x.dist - y.dist);
        pq.add(new Pair(0 , 0));
        
        long[] ways = new long[n];
        ways[0] = 1;
        
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[0] = 0;
        
        int mod = (int)Math.pow(10 , 9) + 7;
        
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int node = curr.node;
            int time = curr.dist;
            
            for(Pair item : adj.get(node)){
                if((time + item.dist) < dist[item.node]){
                    ways[item.node] = ways[node];
                    dist[item.node] = time + item.dist;
                    pq.add(new Pair(item.node , dist[item.node]));
                }
                else if((time + item.dist) == dist[item.node]){
                    ways[item.node] += ways[node];
                    ways[item.node] = ways[item.node] % mod;
                }
            }
        }
        return (int)ways[n - 1];
    }
}
