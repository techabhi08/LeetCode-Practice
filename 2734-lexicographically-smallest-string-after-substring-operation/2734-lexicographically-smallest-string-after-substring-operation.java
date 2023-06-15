class Solution {
    public String smallestString(String s) {
        int i = 0;
        int n = s.length();
        
        char[] ch = s.toCharArray();
        while(i < n && ch[i] == 'a'){
            i++;
        }
        if(i == n){
            ch[n - 1] = 'z';
        }
        
        while(i < n && ch[i] != 'a'){
            --ch[i];
            i++;
        }
        
        return new String(ch);
    }
}