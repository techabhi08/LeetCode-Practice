class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        String vowels = "aeiouAEIOU";

        for(int i = 0; i < s.length(); i++){
            if(vowels.indexOf(s.charAt(i)) != -1){
                sb.append(s.charAt(i));
            }
        }

        String letters = sb.reverse().toString();

        StringBuilder ans = new StringBuilder();
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            if(vowels.indexOf(s.charAt(i)) != -1){
                ans.append(letters.charAt(j++));
            }else{
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}
