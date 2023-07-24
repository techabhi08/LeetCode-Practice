class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 || haystack.length() < needle.length()){
            return -1;
        }
        if(haystack.equals(needle)){
            return 0;
        }
        
        for(int i = 0; i < haystack.length(); i++){
            if(i + needle.length() > haystack.length()){
                return -1;
            }
            int j = 0;
            int start = i;
            while(j < needle.length()){
                if(haystack.charAt(start) == needle.charAt(j)){
                    start++;
                    j++;
                    if(j == needle.length()){
                        return i;
                    }
                }else{
                    break;
                }
            }
        }
        return -1;
    }
}