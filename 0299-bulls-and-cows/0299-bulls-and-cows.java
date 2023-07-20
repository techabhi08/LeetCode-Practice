class Solution {
    public String getHint(String secret, String guess) {
        StringBuilder sec = new StringBuilder(secret);
        StringBuilder gue = new StringBuilder(guess);
        
        Map<Character, Integer> map = new HashMap<>();
        int bulls = 0;
        int cows = 0;
        for(int i = secret.length() - 1; i >= 0; i--){
            if(sec.charAt(i) == gue.charAt(i)){
                bulls++;
                sec.deleteCharAt(i);
                gue.deleteCharAt(i);
            }else{
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }
        
        for(int i = 0; i < gue.length(); i++){
            char ch = gue.charAt(i);
            if(map.containsKey(ch) && map.get(ch) > 0){
                map.put(ch, map.get(ch) - 1);
                cows++;
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}