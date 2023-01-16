class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        prev[0] = 1;
        curr[0] = 1;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    curr[j] = prev[j - 1] + prev[j];
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = (int[])curr.clone();
        }
        
        return prev[m];
    }
}
