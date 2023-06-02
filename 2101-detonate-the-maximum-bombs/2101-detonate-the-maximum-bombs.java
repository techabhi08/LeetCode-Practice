class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int ans = 0;
        
        for(int i = 0; i < bombs.length; i++){
            boolean[] vis = new boolean[n];
            ans = Math.max(ans, findCount(i, vis, bombs));
        }
        return ans;
    }
    
    public int findCount(int index, boolean[] vis, int[][] bombs){
        int count = 1;
        vis[index] = true;
        
        for(int i = 0; i < bombs.length; i++){
            if(!vis[i] && isInRange(bombs[index], bombs[i])){
                count += findCount(i, vis, bombs);
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
