class Pair{
    int dest;
    int cost;
    Pair(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
}

class Tuple{
    int src;
    int cost;
    Tuple(int src, int cost){
        this.src = src;
        this.cost = cost;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < times.length; i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int)1e8);
        
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Tuple(k, 0));
        dist[k] = 0;
        
        while(!pq.isEmpty()){
            Tuple curr = pq.poll();
            int src = curr.src;
            int cost = curr.cost;
            
            for(Pair item : adj.get(src)){
                if(cost + item.cost < dist[item.dest]){
                    dist[item.dest] = cost + item.cost;
                    pq.add(new Tuple(item.dest, dist[item.dest]));
                }
            }
        }
        
        int ans = 0;
        for(int i = 1; i < dist.length; i++){
            if(dist[i] == (int)1e8){
                return -1;
            }else if(ans < dist[i]){
                ans = dist[i];
            }
        }
        return ans;
    }
}