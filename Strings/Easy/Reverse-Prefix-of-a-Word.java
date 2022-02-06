class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        String r = word.substring(0, index + 1);
        
        StringBuilder sb = new StringBuilder();
        sb.append(r);
        
        sb.reverse();
        
        sb.append(word.substring(index + 1));
        
        return sb.toString();
    }
}
