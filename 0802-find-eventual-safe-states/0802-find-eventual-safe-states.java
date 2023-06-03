class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            for(int item : graph[i]){
                adj.get(item).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            list.add(curr);
            for(int item : adj.get(curr)){
                indegree[item]--;
                if(indegree[item] == 0){
                    queue.add(item);
                }
            }
        }
        
        Collections.sort(list);
        return list;
    }
}