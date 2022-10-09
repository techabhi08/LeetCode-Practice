class Pair {
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Tuple{
    int cost;
    int node;
    int stops;
    Tuple(int stops, int node, int cost){
        this.cost = cost;
        this.node = node;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0; i < m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        int[] dist = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = (int)(1e9);
        }
        
        dist[src] = 0;
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0));
        
        while(!queue.isEmpty()){
            Tuple curr = queue.peek();
            queue.poll();
            int stops = curr.stops;
            int node = curr.node;
            int cost = curr.cost;
            
            if(stops > k){
                continue;
            }
            for(Pair item : adj.get(node)){
                int adjNode = item.first;
                int adjCost = item.second;
                
                if(cost + adjCost < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + adjCost;
                    queue.add(new Tuple(stops + 1, adjNode, cost + adjCost));
                }
            }
        }
        if(dist[dst] == (int)(1e9)){
            return -1;
        }
        return dist[dst];
    }
}
