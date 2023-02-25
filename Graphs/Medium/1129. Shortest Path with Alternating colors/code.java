class Solution {
    class Node {
        int number;
        List<Integer> redList;
        List<Integer> blueList;
        
        public Node(int num){
            this.number = num;
            redList = new ArrayList<>();
            blueList = new ArrayList<>();
        }
    }
    
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, Node> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(i, new Node(i));
        }
        
        for(int[] redEdge : redEdges){
            map.get(redEdge[0]).redList.add(redEdge[1]);
        }
        for(int[] blueEdge : blueEdges){
            map.get(blueEdge[0]).blueList.add(blueEdge[1]);
        }
        
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        // int[] = {node, steps, prevColor}
        // visit[i][j] = visit[node][color]
        //redColor = 0, blueColor = 1;
        boolean[][] vis = new boolean[n][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, -1});
        
        ans[0] = 0;
        vis[0][0] = true;
        vis[0][1] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currNum = curr[0];
            int steps = curr[1];
            int prevColor = curr[2];
            
            for(int item : map.get(currNum).redList){
                if(!vis[item][0] && prevColor != 0){
                    if(ans[item] == -1){
                        ans[item] = 1 + steps; 
                    }
                    vis[item][0] = true;
                    queue.add(new int[]{item, steps + 1, 0});
                }
            }
            for(int item : map.get(currNum).blueList){
                if(!vis[item][1] && prevColor != 1){
                    if(ans[item] == -1){
                        ans[item] = 1 + steps; 
                    }
                    vis[item][1] = true;
                    queue.add(new int[]{item, steps + 1, 1});
                }
            }
        }
        return ans;
    }
}
