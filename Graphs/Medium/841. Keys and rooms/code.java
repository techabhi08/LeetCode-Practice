class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(!visited[curr]){
                visited[curr] = true;
                for(int item : rooms.get(curr)){
                    queue.add(item);
                }
            }
        }
        
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
