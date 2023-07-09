class Solution {
    public int largestVariance(String s) {
        int maxi = 0;
        
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }
        
        for(int i = 0; i < 2; i++){
            for(char s1 : set){
                for(char s2 : set){
                    if(s1 == s2){
                        continue;
                    }
                    
                    int count1 = 0, count2 = 0;
                    
                    for(char c : s.toCharArray()){
                        if(c == s1){
                            count1++;
                        }else if(c == s2){
                            count2++;
                        }
                        
                        if(count1 < count2){
                            count1 = count2 = 0;
                        }
                        if(count1 > 0 && count2 > 0){
                            maxi = Math.max(maxi, count1 - count2);
                        }
                    }
                }
            }
            s = new StringBuilder(s).reverse().toString();
        }
        return maxi;
    }
}