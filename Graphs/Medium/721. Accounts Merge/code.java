class DisjointSet {
    int[] parent;
    int[] size;
    
    public DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findParent(int node){
        if(parent[node] == node){
            return node;
        }
        
        int ulp = findParent(parent[node]);
        parent[node] = ulp;
        return parent[node];
    }
    
    public void unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(ulp_u == ulp_v){
            return;
        }
        
        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = ulp_v;
            size[ulp_v] = size[ulp_v] + size[ulp_u];
        }else{
            parent[ulp_v] = ulp_u;
            size[ulp_u] = size[ulp_v] + size[ulp_u];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> mapMail = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!mapMail.containsKey(mail)){
                    mapMail.put(mail, i);
                }else{
                    ds.unionBySize(i, mapMail.get(mail));
                }
            }
        }
        
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for(int i = 0; i < n; i++){
            mergedMail[i] = new ArrayList<>();
        }
        
        for(Map.Entry<String, Integer> item : mapMail.entrySet()){
            String mail = item.getKey();
            int node = ds.findParent(item.getValue());
            mergedMail[node].add(mail);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(mergedMail[i].size() == 0){
                continue;
            }
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String item : mergedMail[i]){
                temp.add(item);
            }
            ans.add(temp);
        }
        return ans;
    }
}
