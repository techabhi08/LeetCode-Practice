class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == s2.charAt(j - 1)){
                    curr[j] = 1 + prev[j - 1];
                }else{
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = (int[])curr.clone();
        }
        return n - prev[n];
    }
}