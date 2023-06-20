class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    curr[j] = 1 + prev[j - 1];
                }else{
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = (int[])curr.clone();
        }
        
        return (n + m) - (2 * prev[m]);
    }
}