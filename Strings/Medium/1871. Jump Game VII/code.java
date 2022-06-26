class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] possible = new boolean[n];
        possible[0] = true;
        
        int l = 0;
        for(int i = 0; i < n; i++){
            if(possible[i]){
                int u = Math.min(i + maxJump, n - 1);
                for(int j = Math.max(l, i + minJump); j <= u; j++){
                    if(s.charAt(j) == '0'){
                        possible[j] = true;
                    }
                }
                l = u + 1;
            }
        }
        return possible[n - 1];
    }
}
