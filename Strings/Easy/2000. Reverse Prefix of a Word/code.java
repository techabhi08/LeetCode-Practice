class Solution {
    public String reversePrefix(String word, char ch) {
//         int index = word.indexOf(ch);
//         if(index == -1){
//             return word;
//         }
        
//         String ans = "";
//         for(int i = index; i >= 0; i--){
//             ans += word.charAt(i);
//         }
//         for(int i = index + 1; i < word.length(); i++){
//             ans += word.charAt(i);
//         }
//         return ans;
        
        int index = word.indexOf(ch);
        StringBuilder sb = new StringBuilder();
        sb.append(word.substring(0, index + 1));
        
        sb.reverse();
        
        sb.append(word.substring(index + 1, word.length()));
        return sb.toString();

    }
}
