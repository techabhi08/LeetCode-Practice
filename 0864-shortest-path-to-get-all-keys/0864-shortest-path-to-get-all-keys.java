class Pair {
    int row;
    int col;
    String key;
    
    Pair(int row, int col, String key){
        this.row = row;
        this.col = col;
        this.key = key;
    }
    
    public String toString(int row , int col , String key) {
		return row+"-"+col+"-"+key;
	}
}

class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        Queue<Pair> queue = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        
        int steps = 0;
        int keys = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i].charAt(j) == '@'){
                    queue.add(new Pair(i, j, ""));
                }else if(grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f'){
                    keys++;
                }
            }
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair curr = queue.poll();
                int row = curr.row;
                int col = curr.col;
                String key = curr.key;
                
                if(!vis.contains(curr.toString(row, col, key))){
                    vis.add(curr.toString(row, col, key));
                }else{
                    continue;
                }
                
                if(key.length() == keys){
                    return steps;
                }
                
                for(int[] dir : dirs){
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];
                    
                    Pair newNode = new Pair(nRow, nCol, key);
                    
                    if(nRow < 0 || nRow >= n || nCol < 0 || nCol >= m || grid[nRow].charAt(nCol) == '#' || vis.contains(newNode.toString(nRow, nCol, key))){
                        continue;
                    }
                    
                    char ch = grid[nRow].charAt(nCol);
                    
                    if(key.indexOf(ch) == -1 && ch >= 'a' && ch <= 'f'){
                        queue.add(new Pair(nRow, nCol, key+ch));
                    }else if(ch >= 'A' && ch <= 'F' && key.indexOf(Character.toLowerCase(ch)) == -1){
                        continue;
                    }else{
                        queue.add(new Pair(nRow, nCol, key));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}