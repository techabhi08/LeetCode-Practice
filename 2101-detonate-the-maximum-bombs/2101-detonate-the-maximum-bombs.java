class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int ans = 0;
        
        for(int i = 0; i < bombs.length; i++){
            ans = Math.max(ans, findCount(i, bombs));
        }
        return ans;
    }
    
    public int findCount(int index, int[][] bombs){
//         int count = 1;
//         vis[index] = true;
        
//         for(int i = 0; i < bombs.length; i++){
//             if(!vis[i] && isInRange(bombs[index], bombs[i])){
//                 count += findCount(i, vis, bombs);
//             }
//         }
        
//         return count;
        int n = bombs.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[n];
        
        vis[index] = true;
        queue.add(index);
        
        int count = 1;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            for(int i = 0; i < n; i++){
                if(!vis[i] && isInRange(bombs[curr], bombs[i])){
                    count++;
                    queue.add(i);
                    vis[i] = true;
                }
            }
        }
        return count;
    }
    
    public boolean isInRange(int[] bomb1, int[] bomb2){
        long x = bomb1[0] - bomb2[0];
        long y = bomb1[1] - bomb2[1];
        long radius = bomb1[2];
        if((x * x + y * y) <= radius * radius){
            return true;
        }
        return false;
    }
}
