class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1){
            return 0;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(arr[i], a -> new ArrayList<>()).add(i);
        }
        
        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        while(!queue.isEmpty()){
            steps += 1;
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                int curr = queue.poll();
                
                if(curr - 1 >= 0 && map.containsKey(arr[curr - 1])){
                    queue.add(curr - 1);
                }
                
                if(curr + 1 < n && map.containsKey(arr[curr + 1])){
                    if(curr + 1 == n - 1){
                        return steps;
                    }
                    queue.add(curr + 1);
                }
                
                if(map.containsKey(arr[curr])){
                    for(int item : map.get(arr[curr])){
                        if(curr != item){
                            if(item == n - 1){
                                return steps;
                            }
                            queue.add(item);
                        }
                    }
                }
                map.remove(arr[curr]);
            }
        }
        return steps;
    }
}
