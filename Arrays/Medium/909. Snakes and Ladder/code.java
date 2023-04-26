class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Map<Integer, Integer> map = new HashMap<>();
        int begin = n * n;
        
        // Indexing each cell from 0 to n alternatively.
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if((n - i) % 2 == 0){
                    map.put(begin, board[i][j]);
                }else{
                    map.put(begin, board[i][n - j - 1]);
                }
                begin--;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.add(1);
        set.add(1);
        int steps = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curr = queue.poll();
                if(curr == n * n){
                    return steps;
                }
                
                for(int j = 1; j <= 6; j++){
                    int destPoint = curr + j;
                    if(destPoint > n * n){
                        continue;
                    }
                    if(map.get(destPoint) != -1){
                        destPoint = map.get(destPoint);
                    }
                    if(!set.contains(destPoint)){
                        set.add(destPoint);
                        queue.add(destPoint);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
