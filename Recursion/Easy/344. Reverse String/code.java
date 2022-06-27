class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        reverse(s, start, end);
    }
    
    public void reverse(char[] s, int srt, int e){
        if(srt <= e){
            char temp = s[srt];
            s[srt] = s[e];
            s[e] = temp;
            reverse(s, srt + 1, e - 1);
        }
    }
}
