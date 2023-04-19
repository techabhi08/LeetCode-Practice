class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        
        if(s.length() < t.length() || t.length() == 0){
            return ans;
        }
        
        int have = 0;
        int need = t.length();
        int minSize = Integer.MAX_VALUE;
        
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            
            if(tMap.containsKey(ch) && sMap.get(ch) <= tMap.get(ch)){
                have++;
            }
            
            while(have == need){
                if(right - left + 1 < minSize){
                    minSize = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                
                char charToRemove = s.charAt(left);
                if(sMap.get(charToRemove) == 1){
                    sMap.remove(charToRemove);
                }else{
                    sMap.put(charToRemove, sMap.get(charToRemove) - 1);
                }
                left++;
                
                if(tMap.containsKey(charToRemove) && sMap.getOrDefault(charToRemove, 0) < tMap.get(charToRemove)){
                    have--;
                }
            }
        }
        return ans;
    }
}
