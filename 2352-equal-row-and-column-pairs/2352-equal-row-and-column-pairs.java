class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Set<int[]> set = new HashSet<>();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            set.add(grid[i]);
        }
        
        for(int i = 0; i < n; i++){
            int[] arr = new int[n];
            for(int j = 0; j < n; j++){
                arr[j] = grid[j][i];
            }
            for(int[] item : set){
                if(Arrays.equals(item, arr)){
                    count++;
                }
            }
        }
        return count;
    }
}