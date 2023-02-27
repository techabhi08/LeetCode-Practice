class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        
        for(int[] road : roads){
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
            indegree[road[1]]++;
            indegree[road[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n; i++){
            if(indegree[i] == 1){
                queue.add(i);
            }
        }
        
        int[] totalMen = new int[n];
        Arrays.fill(totalMen, 1);
        long fuel = 0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            fuel += Math.ceil((double)totalMen[node] / seats);
            
            for(int item : adj.get(node)){
                indegree[item]--;
                totalMen[item] += totalMen[node];
                
                if(indegree[item] == 1 && item != 0){
                    queue.add(item);
                }
            }
        }
        return fuel;
    }
}
