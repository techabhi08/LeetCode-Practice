class DisjointSet {
    int[] parent;
    
    public DisjointSet(){
        parent = new int[26];
    }
    
    public int findParent(int ch){
        if(parent[ch] == ch){
            return ch;
        }
        
        int ulp_p = findParent(parent[ch]);
        parent[ch] = ulp_p;
        return parent[ch];
    }
    
    public void union(int x, int y){
        x = findParent(x);
        y = findParent(y);
        
        if(x == y){
            return;
        }
        if(x < y){
            parent[y] = x;
        }else{
            parent[x] = y;
        }
    }
}

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DisjointSet ds = new DisjointSet();
        String ans = "";
        
        for(int i = 0; i < 26; i++){
            ds.parent[i] = i;
        }
        
        for(int i = 0; i < s1.length(); i++){
            ds.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        
        for(int i = 0; i < baseStr.length(); i++){
            ans += (char)(ds.findParent(baseStr.charAt(i) - 'a') + 'a');
        }
        
        return ans;
    }
}
