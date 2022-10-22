class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        if(t.length() > s.length()){
            return ans;
        }
        if(t.equals(s)){
            return t;
        }
        int minWind = Integer.MAX_VALUE;
        int required = t.length();
        int have = 0;
        
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        
        int start = 0;
        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            sMap.put(c , sMap.getOrDefault(c, 0) + 1);
            
            if(tMap.containsKey(c) && sMap.get(c) <= tMap.get(c)){
                have++;
            }
            
            while(required == have){
                if(minWind > end - start +  1){
                    minWind = end - start + 1;
                    ans = s.substring(start, end + 1);
                }
                
                //finding a shorter window if possible
                char removeChar = s.charAt(start);
                if(sMap.get(removeChar) == 1){
                    sMap.remove(removeChar);
                }else{
                    sMap.put(removeChar, sMap.get(removeChar) - 1);
                }
                start++;
                
                if(tMap.containsKey(removeChar) && sMap.getOrDefault(removeChar, 0) < tMap.get(removeChar)){
                    have--;
                }
            }
        }
        return ans;
    }
}
