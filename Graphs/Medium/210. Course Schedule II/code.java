class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());  
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int item : adj.get(i)){
                indegree[item]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        int[] topo = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            topo[index++] = curr;
            
            for(int item : adj.get(curr)){
                indegree[item]--;
                if(indegree[item] == 0){
                    queue.add(item);
                }
            }
        }
        
        if(index != numCourses){
            return new int[]{};
        }
        return topo;
    }
}
