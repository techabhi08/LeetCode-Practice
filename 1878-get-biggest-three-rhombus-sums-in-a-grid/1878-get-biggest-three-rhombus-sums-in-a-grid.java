class Solution {
    public int[] getBiggestThree(int[][] grid) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Set<Integer> set = new HashSet<>();
        
        List<Integer> temp = new ArrayList<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!set.contains(grid[i][j])){
                    pq.add(grid[i][j]);
                    set.add(grid[i][j]);
                }
            }
        }
        
        int row = grid.length / 2;
        int col = grid[0].length / 2;
        int mini = Math.min(row, col);
        
        int expand = 1;
        while(expand <= mini){
            
            for(int i = 0; i < grid.length - mini; i++){
                for(int j = expand; j < grid[0].length; j++){
                    int sum = 0;
                    int count = 0;
                    int start1 = i;
                    int start2 = j;
                    int end1 = i + expand;
                    int end2 = j - expand;
                    
                    while(start1 < end1 && start2 > end2){
                        if(start1 >= 0 && start1 < grid.length && start2 >= 0 && start2 < grid[0].length){
                            sum += grid[start1][start2];
                            start1++;
                            start2--;
                        }else{
                            count++;
                            break;
                        }
                    }
                    
                    start1 = end1;
                    start2 = end2;
                    end1 = start1 + expand;
                    end2 = start2 + expand;
                    
                    while(start1 < end1 && start2 < end2){
                        if(start1 >= 0 && start1 < grid.length && start2 >= 0 && start2 < grid[0].length){
                            sum += grid[start1][start2];
                            start1++;
                            start2++;
                        }else{
                            count++;
                            break;
                        }
                    }
                    
                    start1 = end1;
                    start2 = end2;
                    end1 = start1 - expand;
                    end2 = start2 + expand;
                    
                    while(start1 > end1 && start2 < end2){
                        if(start1 >= 0 && start1 < grid.length && start2 >= 0 && start2 < grid[0].length){
                            sum += grid[start1][start2];
                            start1--;
                            start2++;
                        }else{
                            count++;
                            break;
                        }
                    }
                    
                    start1 = end1;
                    start2 = end2;
                    end1 = start1 - expand;
                    end2 = start2 - expand;
                    
                    while(start1 > end1 && start2 > end2){
                        if(start1 >= 0 && start1 < grid.length && start2 >= 0 && start2 < grid[0].length){
                            sum += grid[start1][start2];
                            start1--;
                            start2--;
                        }else{
                            count++;
                            break;
                        }
                    }
                    
                    if(count == 0){
                        if(!set.contains(sum)){
                            set.add(sum);
                            pq.add(sum);
                        }
                    }
                }
            }
            expand++;
        }
        temp.add(pq.poll());
        
        if(!pq.isEmpty()){
            temp.add(pq.poll());
        }
        
        if(!pq.isEmpty()){
            temp.add(pq.poll());
        }
        
        int[] ans = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            ans[i] = temp.get(i);
        }
        return ans;
    }
}