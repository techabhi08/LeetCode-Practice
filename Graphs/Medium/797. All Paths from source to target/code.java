class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans =  new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(0, ans, temp, graph);
        return ans;
    }
    
    public void dfs(int index, List<List<Integer>> ans, List<Integer> temp, int[][] graph){
        if(index == graph.length - 1){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int item : graph[index]){
            temp.add(item);
            dfs(item, ans, temp, graph);
            temp.remove(temp.size() - 1);
        }
    }
}
