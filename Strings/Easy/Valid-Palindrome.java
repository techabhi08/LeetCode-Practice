class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        String str = s.toLowerCase();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(isDigitOrChar(str.charAt(i))){
                ans.append(str.charAt(i));

            }
        }
        String ori = ans.toString();
        // System.out.println(ori);

        String revers = ans.reverse().toString();
        // System.out.println(revers);
        if(revers.contentEquals(ori)){
            return true;
        }

        return false;
    }
    
    public boolean isDigitOrChar(Character ch){
        return Character.isLetterOrDigit(ch);
    }
}
