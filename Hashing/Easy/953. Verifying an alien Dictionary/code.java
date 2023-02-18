class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }
        
        for(int i = 0; i < words.length - 1; i++){
            for(int j = 0; j < words[i].length(); j++){
                if(j >= words[i + 1].length()){
                    return false;
                }
                char currChar = words[i].charAt(j);
                char nextChar = words[i + 1].charAt(j);
                
                if(currChar != nextChar){
                    if(map.get(currChar) > map.get(nextChar)){
                        return false;
                    }else{
                        break;
                    }
                }
            }
        }
        return true;
    }
}
