class Solution {
    public boolean judgeCircle(String moves) {
        if(moves.isEmpty()){
            return true;
        }
        
        int r = 0;
        int u = 0;
        
        for(char s : moves.toCharArray()){
            if(s == 'R'){
                r++;
            }
            if(s == 'L'){
                r--;
            }
            if(s == 'U'){
                u++;
            }
            if(s == 'D'){
                u--;
            }
        }
        return (r == 0 && u == 0);
    }
}
