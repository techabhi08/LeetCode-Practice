class Solution {
    public boolean judgeCircle(String moves) {
        if(moves.isEmpty()){
            return true;
        }
        
        int l = 0;
        int d = 0;
        for(char c : moves.toCharArray()){
            if(c == 'R'){
                l--;
            }else if(c == 'L'){
                l++;
            }else if(c == 'D'){
                d++;
            }else{
                d--;
            }
        }
        return (l == 0 && d == 0);
    }
}
