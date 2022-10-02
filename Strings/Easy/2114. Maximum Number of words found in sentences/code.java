class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans = 0;
        for(String str : sentences){
            int count = 0;
            char[] words = str.toCharArray();
            for(char c : words){
                if(c == ' '){
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans + 1;
    }
}
