class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        
        String allVowel = "aeiouAEIOU";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(allVowel.indexOf(ch) != -1){
                vowels.add(ch);
                pos.add(i);
            }
        }
        
        Collections.sort(vowels);
        char[] t = s.toCharArray();
        for(int i = 0; i < pos.size(); i++){
            t[pos.get(i)] = vowels.get(i);
        }
        return new String(t);
    }
}