class Solution {
    public int secondsToRemoveOccurrences(String s) {
        StringBuilder sb = new StringBuilder(s);
        int seconds = 0;
        while(sb.indexOf("01") != -1){
            seconds++;
            for(int i = 0; i < s.length() - 1; i++){
                if(sb.charAt(i) == '0' && sb.charAt(i + 1) == '1'){
                    sb.setCharAt(i, '1');
                    sb.setCharAt(i + 1, '0');
                    i++;
                }
            }
        }
        return seconds;
    }
}
