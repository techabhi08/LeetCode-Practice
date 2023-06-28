class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == goal.charAt(0)){
                String newStr = s.substring(i) + s.substring(0, i);
                if(newStr.equals(goal)){
                    return true;
                }
            }
            i++;
        }
        return false;
    }
}