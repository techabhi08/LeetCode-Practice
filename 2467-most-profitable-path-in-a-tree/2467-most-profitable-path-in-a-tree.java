class Solution {
    List<Integer> b2a = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            adj.put(i, new HashSet<>());
        }
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        List<Integer> temp = new ArrayList<>();
        temp.add(bob);
        Set<Integer> tempSet = new HashSet<>();
        tempSet.add(bob);
        dfs(bob, 0, adj, temp, tempSet);
        
        for(int i = 0; i < b2a.size() / 2; i++){
            amount[b2a.get(i)] = 0;
        }
        
        if(b2a.size() % 2 != 0){
            amount[b2a.get(b2a.size() / 2)] /= 2;
        }
        
        Set<Integer> vis = new HashSet<>();
        vis.add(0);
        findMax(0, amount[0], adj, amount, vis);
        return max;
    }
    
    public boolean dfs(int start, int target, Map<Integer, Set<Integer>> adj, List<Integer> currPath, Set<Integer> vis){
        if(start == target){
            b2a = new ArrayList<>(currPath);
            return true;
        }
        
        for(int item : adj.get(start)){
            if(!vis.contains(item)){
                vis.add(item);
                currPath.add(item);
                if(dfs(item, target, adj, currPath, vis)){
                    return true;
                }
                vis.remove(item);
                currPath.remove(currPath.size() - 1);
            }
        }
        return false;
    }
    
    public void findMax(int start, int sum, Map<Integer, Set<Integer>> map, int[] amount, Set<Integer> vis){
        int count = 0;
        for(int child : map.get(start)){
            if(!vis.contains(child)){
                vis.add(child);
                findMax(child, sum + amount[child], map, amount, vis);
                vis.remove(child);
                count++;
            }
        }
        
        if(count == 0){
            max = Math.max(max, sum);
        }
    }
}