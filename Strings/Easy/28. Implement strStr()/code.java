class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        
        for(int i = 0; i < haystack.length(); i++){
            if(i + needle.length() > haystack.length()){
                return -1;
            }
            int count = i;
            for(int j = 0; j < needle.length(); j++){
                if(needle.charAt(j) == haystack.charAt(count)){
                    count++;
                    if(j == needle.length() - 1){
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
