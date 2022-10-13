class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes);
        int len = sb.length();
        
        //making all the unpushed domino true, after pushing the prev right block
        char prev = '.';
        boolean[] right = new boolean[len];
        for(int i = 0; i < len; i++){
            char ch = dominoes.charAt(i);
            if(ch == '.'){
                if(prev == 'R'){
                    right[i] = true;
                }
            }else{
                prev = ch;
            }
        }
        
        //making all the unpushed domino true, after pushing the prev left block
        prev = '.';
        boolean[] left = new boolean[len];
        for(int i = len - 1; i >= 0; i--){
            char ch = dominoes.charAt(i);
            if(ch == '.'){
                if(prev == 'L'){
                    left[i] = true;
                }
            }else{
                prev = ch;
            }
        }
        
        //marking the blocks according to the fall
        int i = 0;
        while(i < len){
            
            //Checking if the force os towards left from prev block & not right
            if(left[i] && !right[i]){
                sb.setCharAt(i++, 'L');
            }
            //Checking if the resultant force is towards right
            else if(!left[i] && right[i]){
                sb.setCharAt(i++, 'R');
            }
            //Checking if the force from both side.
            else if(left[i] && right[i]){
                int j = (i + 1);
                while(j < len && left[j] && right[j]){
                    j++;
                }
                dropTheDominoes(sb, i, j - 1);
                i = j;
            }
            //If there is no force from either sides
            else{
                i++;
            }
        }
        return sb.toString();
    }
    
    public void dropTheDominoes(StringBuilder sb, int i, int j){
        while(i < j){
            sb.setCharAt(i++, 'R');
            sb.setCharAt(j--, 'L');
        }
    }
}
