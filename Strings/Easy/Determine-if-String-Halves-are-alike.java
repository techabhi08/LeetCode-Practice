class Solution {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
    
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < s.length()/2; i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'e'){
                count1++;
            }
        }
        
        for(int i = s.length()/2; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'e'){
                count2++;
            }
        }
        
        if(count1 == count2){
            return true;
        }
        return false;
        
    }
}
