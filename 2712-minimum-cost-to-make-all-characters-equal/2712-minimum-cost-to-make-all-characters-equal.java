class Solution {
    public long minimumCost(String s) {
        long res = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(i - 1)){
                if(i < s.length() - i){
                    res += i;
                }else{
                    res += s.length() - i;
                }
            }
        }
        return res;
    }
}