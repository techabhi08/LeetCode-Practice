class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int item : graph[i]){
                adj.get(item).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            ans.add(curr);
            
            for(int item : adj.get(curr)){
                indegree[item]--;
                if(indegree[item] == 0){
                    queue.add(item);
                }
            }
        }
        ans.sort(null);
        return ans;
    }
}