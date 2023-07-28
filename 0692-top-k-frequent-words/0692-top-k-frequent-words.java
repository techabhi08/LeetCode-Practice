class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<String> temp = new ArrayList<>();
        
        for(int i = 0; i < words.length; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            if(!temp.contains(words[i])){
                temp.add(words[i]);
            }
        }
        
        Collections.sort(temp, (a, b) -> map.get(a).equals(map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a));
        
        int i = 0;
        while(k-- > 0){
            ans.add(temp.get(i++));
        }
        return ans;
    }
}