class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String ans = "";
        
        for(String word : arr){
            for(int i = word.length() - 1; i >= 0; i--){
                ans += word.charAt(i);
            }
            ans += " ";
        }
        
        return ans.trim();
    }
}
