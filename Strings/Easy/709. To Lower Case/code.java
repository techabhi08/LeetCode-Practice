class Solution {
    public String toLowerCase(String s) {
        // return s.toLowerCase();
        
        StringBuilder str = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(c >= 'A' && c <= 'Z'){
                c = (char)(c + 32);
            }
            str.append(c);
        }
        return str.toString();
    }
}
