class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        
        if(s.equals(goal)){
            int[] freq = new int[26];
            for(int i = 0; i < s.length(); i++){
                int ch = s.charAt(i) - 'a';
                freq[ch]++;
                if(freq[ch] == 2){
                    return true;
                }
            }
            return false;
        }
        
        int num1 = -1, num2 = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)){
                if(num1 == -1){
                    num1 = i;
                }else if(num2 == -1){
                    num2 = i;
                }else{
                    return false;
                }
            }
        }
        if(num2 == -1){
            return false;
        }
        return (s.charAt(num1) == goal.charAt(num2) && goal.charAt(num1) == s.charAt(num2));
    }
}