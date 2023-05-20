class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = build(equations, values);
        double[] ans = new double[queries.size()];
        
        for(int i = 0; i < queries.size(); i++){
            ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        
        return ans;
    }
    
    public Map<String, Map<String, Double>> build(List<List<String>> equations, double[] values){
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for(int i = 0; i < equations.size(); i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1 / values[i]);
        }
        return graph;
    }
    
    public double dfs(String s1, String s2, Set<String> set, Map<String, Map<String, Double>> graph){
        if(!graph.containsKey(s1)){
            return -1.0;
        }
        
        if(graph.get(s1).containsKey(s2)){
            return graph.get(s1).get(s2);
        }
        
        set.add(s1);
        
        for(Map.Entry<String, Double> item : graph.get(s1).entrySet()){
            if(!set.contains(item.getKey())){
                double weight = dfs(item.getKey(), s2, set, graph);
                
                if(weight != -1.0){
                    return item.getValue() * weight;
                }
            }
        }
        
        return -1.0;
    }
}