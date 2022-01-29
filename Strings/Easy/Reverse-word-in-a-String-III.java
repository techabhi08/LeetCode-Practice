class Solution {
    public String reverseWords(String s) {
        String ans = "";
        String[] str = s.split(" ");
        for(int i = 0; i < str.length; i++){
            for(int j = str[i].length() - 1; j>= 0; j--){
                ans += str[i].charAt(j) + "";
            }
            ans += " ";
        }
        return ans.substring(0, ans.length()-1);
    }
}
