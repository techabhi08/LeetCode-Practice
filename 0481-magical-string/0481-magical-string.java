class Solution {
    public int magicalString(int n) {
        StringBuilder str = new StringBuilder("122");
        int p1 = 2;
        int p2 = str.length() - 1;
        int count = 0;
        
        while(str.length() < n){
            if(str.charAt(p1) == '1'){
                if(str.charAt(p2) == '1'){
                    str.append("2");
                }else{
                    str.append("1");
                }
                p2++;
            }else{
                if(str.charAt(p2) == '1'){
                    str.append("22");
                }else{
                    str.append("11");
                }
                p2 += 2;
            }
            p1++;
        }
        
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}