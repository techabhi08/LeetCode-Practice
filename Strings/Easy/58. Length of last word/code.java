class Solution {
    public int lengthOfLastWord(String s) {
//         s = s.trim();
//         String[] arr = s.split(" ");
        
//         String last_word = arr[(arr.length - 1)].trim();
//         return last_word.length();
        
        int count = 0;
        String str = s.trim();
        
        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) == ' '){
                break;
            }else{
                count++;
            }
        }
        return count;
        
    }
}
