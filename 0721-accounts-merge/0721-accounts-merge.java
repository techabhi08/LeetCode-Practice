class DisjointSet{
    int[] parent;
    int[] size;
    
    DisjointSet(int n){
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
        return ulp;
    }
    
    public void union(int u, int v){
        u = findParent(u);
        v = findParent(v);
        
        if(u == v){
            return;
        }
        if(size[u] < size[v]){
            parent[u] = v;
            size[v] = size[u] + size[v];
        }else{
            parent[v] = u;
            size[u] = size[u] + size[v];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        
        Map<String, Integer> mailList = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!mailList.containsKey(mail)){
                    mailList.put(mail, i);
                }else{
                    ds.union(i, mailList.get(mail));
                }
            }
        }
        
        ArrayList<String>[] mergedMails = new ArrayList[n];
        for(int i = 0; i < n; i++){
            mergedMails[i] = new ArrayList<>();
        }
        
        for(Map.Entry<String, Integer> item : mailList.entrySet()){
            String mail = item.getKey();
            int node = ds.findParent(item.getValue());
            mergedMails[node].add(mail);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(mergedMails[i].size() == 0){
                continue;
            }
            Collections.sort(mergedMails[i]);
            String mail = accounts.get(i).get(0);
            List<String> inner = new ArrayList<>();
            inner.add(mail);
            
            for(String item : mergedMails[i]){
                inner.add(item);
            }
            ans.add(inner);
        }
        return ans;
    }
}