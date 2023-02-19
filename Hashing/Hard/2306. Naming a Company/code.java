class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] groupInitial = new HashSet[26];
        
        for(int i = 0; i < 26; i++){
            groupInitial[i] = new HashSet<>();
        }
        
        for(String idea : ideas){
            groupInitial[idea.charAt(0) - 'a'].add(idea.substring(1));
        }
        
        long ans = 0;
        for(int i = 0; i < 25; i++){
            for(int j = i + 1; j < 26; j++){
                
                long common = 0;
                for(String idea : groupInitial[i]){
                    if(groupInitial[j].contains(idea)){
                        common++;
                    }
                }
                ans += 2 * (groupInitial[i].size() -  common) * (groupInitial[j].size() - common);
            }
        }
        return ans;
    }
}
