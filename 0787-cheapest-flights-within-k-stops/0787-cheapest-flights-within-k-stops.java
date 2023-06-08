class Pair{
    int dest;
    int cost;
    
    Pair(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
}

class Tuple {
    int stops;
    int src;
    int cost;
    
    Tuple(int stops, int src, int cost){
        this.stops = stops;
        this.src = src;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e8);
        
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0));
        
        while(!queue.isEmpty()){
            Tuple curr = queue.poll();
            int stops = curr.stops;
            int s = curr.src;
            int c = curr.cost;
            
            if(stops > k){
                continue;
            }
            
            for(Pair item : adj.get(s)){
                if(c + item.cost < dist[item.dest] && stops <= k){
                    dist[item.dest] = c + item.cost;
                    queue.add(new Tuple(stops + 1, item.dest, dist[item.dest]));
                }
            }
        }
        
        if(dist[dst] == (int)1e8){
            return -1;
        }
        return dist[dst];
    }
}