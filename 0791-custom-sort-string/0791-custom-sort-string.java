class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        String ans = "";
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(!map.containsKey(c)){
               continue; 
            }
            int count = map.get(c);
            while(count-- != 0){
                ans += c + "";
            }
            map.remove(c);
        }
        
        for(Character key : map.keySet()){
            int count = map.get(key);
            while(count-- != 0){
                ans += key + "";
            }
        }
        return ans;
    }
}