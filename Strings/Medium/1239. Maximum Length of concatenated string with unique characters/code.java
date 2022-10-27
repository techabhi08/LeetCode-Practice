class Solution {
    public int maxLength(List<String> arr) {
        List<String> list = new ArrayList<>();
        int ans = 0;
        for(String s : arr){
            List<String> inner = new ArrayList<>();
            
            if(!isUnique(s)){
                continue;
            }
            inner.add(s);
            ans = Math.max(ans, s.length());
            
            for(String str : list){
                String comb = str + s;
                
                if(isUnique(comb)){
                    inner.add(comb);
                    ans = Math.max(ans, comb.length());
                }
            }
            list.addAll(inner);
        }
        return ans;
    }
    
    public boolean isUnique(String s){
        int[] freq = new int[26];
        
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
            if(freq[c - 'a'] > 1){
                return false;
            }
        }
        return true;
    }
}
