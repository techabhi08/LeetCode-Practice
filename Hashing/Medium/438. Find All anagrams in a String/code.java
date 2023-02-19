class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() < p.length()){
            return list;
        }
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        for(int i = 0; i < p.length(); i++){
            freq1[s.charAt(i) - 'a']++;
            freq2[p.charAt(i) - 'a']++;
        }
        
        if(Arrays.equals(freq1, freq2)){
            list.add(0);
        }
        
        for(int i = p.length(); i < s.length(); i++){
            freq1[s.charAt(i) - 'a']++;
            freq1[s.charAt(i - p.length()) - 'a']--;
        
            if(Arrays.equals(freq1, freq2)){
                list.add(i - p.length() + 1);
            }   
        }
        return list;
    }
}
