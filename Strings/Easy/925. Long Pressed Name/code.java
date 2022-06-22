class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.length() > typed.length()){
            return false;
        }
        
        if(name.equals(typed)){
            return true;
        }
        
        int j = 0;
        for(int i = 0; i < typed.length(); i++){
            if(j < name.length() && name.charAt(j) == typed.charAt(i)){
                j++;
            }
            else if(j == 0 || typed.charAt(i) != typed.charAt(i-1)){
                return false;
            }
        }
        return j == name.length();
    }
}
