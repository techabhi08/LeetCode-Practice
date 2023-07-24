class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int ans = 0;
        String word = words[words.length - 1];
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == ' '){
                continue;
            }
            ans++;
        }
        return ans;
    }
}