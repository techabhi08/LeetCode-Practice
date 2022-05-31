class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        
        int j = 0;
        for(int i = 0; i < s.length; i++){
            if(j < g.length && g[j] <= s[i]){
                count++;
                j++;
            }
        }
        return count;
    }
}
