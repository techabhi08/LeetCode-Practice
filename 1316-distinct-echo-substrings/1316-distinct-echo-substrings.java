class Solution {
    public int distinctEchoSubstrings(String text) {
        HashSet<String> set = new HashSet<>();
        
        for(int len = 1; len <= text.length() / 2; len++){
            int count = 0;
            int i = 0;
            for(int j = len; j < text.length(); j++){
                if(text.charAt(i) == text.charAt(j)){
                    count++;
                }else{
                    count = 0;
                }
                
                if(count == len){
                    String str = text.substring(i + 1, j + 1);
                    // System.out.println(str);
                    set.add(str);
                    count--;
                }
                i++;
            }
        }
        return set.size();
    }
}