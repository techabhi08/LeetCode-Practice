class Pair{
    int id;
    int time;
    Pair(int id, int time){
        this.id = id;
        this.time = time;
    }
}
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int i = 0; i < manager.length; i++){
            int m = manager[i];
            if(m != -1){
                map.get(m).add(i);
            }
        }
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(headID, 0));
        int ans = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                Pair curr = queue.poll();
                int id = curr.id;
                int time = curr.time;
                
                ans = Math.max(ans, time);
                
                int nTime = informTime[id];
                
                for(int item : map.get(id)){
                    queue.add(new Pair(item, time + nTime));
                }
            }
        }
        
        return ans;
    }
}