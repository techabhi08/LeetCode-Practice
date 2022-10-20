class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        List<String> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        
        for(String str : words){
            map.put(str, map.getOrDefault(str, 0) + 1);
            if(!result.contains(str)){
                result.add(str);
            }
        }
        
        Collections.sort(result, (s1, s2) -> map.get(s1).equals(map.get(s2)) ? s1.compareTo(s2) : map.get(s2) - map.get(s1));
        
        int i = 0;
        while(i < k){
            ans.add(result.get(i++));
        }
        return ans;
    }
}
