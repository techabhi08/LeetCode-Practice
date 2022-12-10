class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        return convertString(s).equals(convertString(t));
    }
    
    public String convertString(String str){
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++){
            char c1 = str.charAt(i);
            
            if(!map.containsKey(c1)){
                map.put(c1, i);
            }
            
            sb.append(map.get(c1) + " ");
        }
        
        return sb.toString();
    }
}
