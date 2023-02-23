class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        
        findDistance(node1, edges, dist1);
        findDistance(node2, edges, dist2);
        
        // for(int num : dist1){
        //     System.out.println(num);
        // }
        // for(int num : dist2){
        //     System.out.println(num);
        // }
        
        int minNode = -1;
        int currMin = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            if(currMin > Math.max(dist1[i], dist2[i])){
                minNode = i;
                currMin = Math.max(dist1[i], dist2[i]);
            }
        }
        return minNode;
    }
    
    public void findDistance(int node, int[] edges, int[] dist){
        int n = edges.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);
        queue.add(node);
        dist[node] = 0;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(vis[curr]){
                continue;
            }
            vis[curr] = true;
            int edgeTo = edges[curr];
            
            if(edgeTo != -1 && !vis[edgeTo]){
                dist[edgeTo] = 1 + dist[curr];
                queue.add(edgeTo);
            }
        }
    }
}
