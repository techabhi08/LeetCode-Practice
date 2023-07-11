class Solution {
    public int minimumBeautifulSubstrings(String s) {
        return findMax(0, s);
    }
    
    public int findMax(int index, String s){
        if(index == s.length()){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = index + 1; i <= s.length(); i++){
            String str = s.substring(index, i);
            if(isValid(str)){
                int partition = findMax(i, s);
                if(partition != -1){
                    min = Math.min(min, partition + 1);
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    public boolean isValid(String s){
        if(s.startsWith("0")){
            return false;
        }
        int val = Integer.parseInt(s, 2);
        return isPowerOfFive(val);
    }
    
    public boolean isPowerOfFive(int val){
        while(val % 5 == 0){
            val /= 5;
        }
        return val == 1;
    }
}