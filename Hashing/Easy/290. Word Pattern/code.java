class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Boolean> map2 = new HashMap<>();
        
        if(words.length != pattern.length()){
            return false;
        }
        
        for(int i = 0; i < words.length; i++){
            char c = pattern.charAt(i);
            
            if(!map1.containsKey(c)){
                if(map2.containsKey(words[i])){
                    return false;
                }else{
                    map1.put(c, words[i]);
                    map2.put(words[i], true);
                }
            }else{
                String word = map1.get(c);
                if(word.equals(words[i]) == false){
                    return false;
                }
            }
        }
        return true;
    }
}
