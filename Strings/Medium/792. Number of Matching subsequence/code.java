class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        for(String str : map.keySet()){
            int i = 0;
            int j = 0;
            while(i < str.length() && j < s.length()){
                if(str.charAt(i) == s.charAt(j)){
                    i++;
                    j++;
                }
                else if(str.charAt(i) != s.charAt(j)){
                    j++;
                }
            }
            if(i == str.length()){
                count += map.get(str);
            }
        }
        return count;
    }
}
