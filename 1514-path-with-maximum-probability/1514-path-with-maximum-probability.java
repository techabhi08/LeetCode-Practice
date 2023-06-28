class Pair{
    int node;
    double prob;
    Pair(int node, double prob){
        this.node = node;
        this.prob = prob;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {  
            public int compare(Pair a, Pair b) {
                if(a.prob < b.prob) return 1;
                else if(a.prob > b.prob) return -1;
                return 0;
            }
        });
        pq.add(new Pair(start, 1));
        
        boolean[] vis = new boolean[n];
        double res = Integer.MIN_VALUE;
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            
            if(curr.node == end){
                res = Math.max(res, curr.prob);
            }
            vis[curr.node] = true;
            for(Pair item : adj.get(curr.node)){
                if(!vis[item.node]){
                    pq.add(new Pair(item.node, item.prob * curr.prob));
                }
            }
        }
        
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}