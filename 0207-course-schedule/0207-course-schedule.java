class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
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
        
        int i = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            i++;
            for(int item : adj.get(curr)){
                indegree[item]--;
                if(indegree[item] == 0){
                    queue.add(item);
                }
            }
        }
        
        return i == numCourses;
    }
}